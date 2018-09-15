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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }



    RecyclerView recyclerView;
    CustomAdaptor adapter;
    ProgressDialog pd;
    EditText editText;
    Button btn;
    public static final String TAG="SearchFragment";
    Activity This;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_search, container, false);

        This=getActivity();

        editText=v.findViewById(R.id.EditView);
        btn=v.findViewById(R.id.search);
        recyclerView=v.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(This));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                if(name.equals(""))
                    editText.setError("Enter Something to search");
                else{
                    pd= new ProgressDialog(This);
                    pd.setCanceledOnTouchOutside(true);
                    pd.setTitle("Downloading");
                    pd.setMessage("Processing...");

                    pd.show();

                    Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

                    Log.d(TAG,"onCreate");
                    Api api = retrofit.create(Api.class);

                    //Call<Hero> call = api.getHeroes();

                    Log.d(TAG,"got call refrence");
                    //call
                            api.call_articles(name).enqueue(new Callback<Hero>() {
                        @Override
                        public void onResponse(Call<Hero> call, Response<Hero> response) {
                            Hero hero = response.body();

                            Log.d(TAG,"inside onResponse " + response.isSuccessful()+"  "+hero + " " + hero.getHero());

                            Hero1 hero1=hero.getHero();

                            ArrayList<Image> img1=hero1.getImg();

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

                }
            }
        });

        return v;
    }

}
