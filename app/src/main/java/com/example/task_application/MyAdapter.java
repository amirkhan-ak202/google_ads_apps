package com.example.task_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>
{
    String[] list;
    Buttonclick btnClick;

    public MyAdapter(String[] list, Buttonclick btnClick) {
        this.list = list;
        this.btnClick = btnClick;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_name,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {

        holder.country_name.setText(list[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClick.btnClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }
    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView country_name;
        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            country_name = itemView.findViewById(R.id.country_name);
        }
    }
}
