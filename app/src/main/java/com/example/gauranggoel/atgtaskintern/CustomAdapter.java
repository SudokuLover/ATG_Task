package com.example.gauranggoel.atgtaskintern;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by gaurang goel on 25-07-2018.
 */

class CustomAdaptor  extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder>{
    Context context;
    List<Image> uploads;

    public CustomAdaptor(Context context, List<Image> uploads) {

        this.context = context;
        this.uploads = uploads;
    }

    //now create a nested class

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imagevIew;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView =  itemView.findViewById(R.id.textView);
            imagevIew=  itemView.findViewById(R.id.image_view);
        }
    }

    //now inherit RecyclerView.Adapter<CustomAdaptor.MyViewHolder>
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Image upload = uploads.get(position);
        //uploads  is a list
        holder.textView.setText(upload.getId());
        Glide.with(context).load(upload.getUrl_s()).into(holder.imagevIew);

    }
    @Override
    public int getItemCount() {
        return uploads.size();
    }

}
/*

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

*/
/**
 * Created by gaurang goel on 15-09-2018.
 *//*


public class CustomAdapter extends RecyclerView.ViewHolder<CustomAdapter.MyViewHolder>{


    List<Image> img;
    Context context;

    public CustomAdapter( Context context , List<Image> img) {
        this.img = img;
        this.context = context;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imagevIew;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView =  itemView.findViewById(R.id.textView);
            imagevIew=  itemView.findViewById(R.id.image_view);
        }


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Image img1 = img.get(position);
        //uploads  is a list
        holder.textView.setText(img1.getId());
        Glide.with(context).load(img1.getUrl_s()).into(holder.imagevIew);
    }
    @Override
    public int getItemCount() {
        return img.size();
    }

}
*/
