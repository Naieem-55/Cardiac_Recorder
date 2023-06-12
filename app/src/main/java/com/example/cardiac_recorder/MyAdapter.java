package com.example.cardiac_recorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);

        holder.Systolic.setText(user.getSystolic());
        holder.Diastolic.setText(user.getDiastolic());
        holder.HeartRate.setText(user.getHeartRate());
        holder.Date.setText(user.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Systolic, Diastolic , HeartRate , Date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Systolic = itemView.findViewById(R.id.systolicText);
            Diastolic = itemView.findViewById(R.id.diastolicText);
            HeartRate = itemView.findViewById(R.id.heartText);
            Date = itemView.findViewById(R.id.dateText);
        }
    }

}
