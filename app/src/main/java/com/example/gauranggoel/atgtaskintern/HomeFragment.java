package com.example.gauranggoel.atgtaskintern;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    CustomAdaptor adapter;
    ProgressDialog pd;
    public static final String TAG="HomeFragment";
    Activity This;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);

        This=getActivity();
        recyclerView=v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(This));


        pd= new ProgressDialog(This);
        pd.setCanceledOnTouchOutside(true);
        pd.setTitle("Downloading");
        pd.setMessage("Processing...");

        pd.show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Log.d(TAG,"onCreate");
        Api api = retrofit.create(Api.class);

        Call<Hero> call = api.getHeroes();

        Log.d(TAG,"got call refrence");
        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                Hero hero = response.body();

                Log.d(TAG,"inside onResponse " + response.isSuccessful()+"  "+hero + " " + hero.getHero());

                Hero1 hero1=hero.getHero();


                ArrayList<Image> img1=hero1.getImg();


                //Toast.makeText(MainActivity.this, ""+img1.get(0).getIsfriend()+" ", Toast.LENGTH_SHORT).show();

                adapter = new CustomAdaptor(This, img1);
                recyclerView.setAdapter(adapter);

                if(pd!=null)
                    pd.dismiss();
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {

                Log.d(TAG,"onFailure"+t.getMessage());
                Toast.makeText(This, "Data processing is failed, please check your internet connection", Toast.LENGTH_SHORT).show();

                if(pd!=null)
                    pd.dismiss();
            }
        });


        return v;
    }

}
