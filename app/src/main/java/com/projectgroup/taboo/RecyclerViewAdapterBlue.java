package com.projectgroup.taboo;

/**
 * Created by tomaszkubit on 23/11/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterBlue extends RecyclerView.Adapter<RecyclerViewAdapterBlue.ViewHolder>{

    List<String> listOfNamesBlue;
    Context context;
    View view1;
    ViewHolder viewHolder1;

    public RecyclerViewAdapterBlue(Context context1, List<String> listOfNamesBlue){

        this.listOfNamesBlue = listOfNamesBlue;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View v){

            super(v);

            textView = (TextView)v.findViewById(R.id.subject_textview);
        }
    }

    @Override
    public RecyclerViewAdapterBlue.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_items,parent,false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.textView.setText(listOfNamesBlue.get(position));
    }

    @Override
    public int getItemCount(){

        return listOfNamesBlue.size();
    }
}