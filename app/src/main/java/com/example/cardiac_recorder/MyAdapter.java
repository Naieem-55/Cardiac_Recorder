package com.example.cardiac_recorder;

import android.content.Context;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;
    private OnItemClickListener listener;
    public static int itemPosition ;

    public interface OnItemClickListener{
        default void onItemClick(int position){

        }
    }

    public void  setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent , false);

        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.Systolic.setText(user.getSystolic());
        holder.Diastolic.setText(user.getDiastolic());
        holder.HeartRate.setText(user.getHeartRate());
        holder.Date.setText(user.getDate());

        if(user.isSysInvalid()){
            holder.Systolic.setTextColor(context.getColor(R.color.red));
        }
        else{
            holder.Systolic.setTextColor(context.getColor(R.color.black));
        }
        if(user.isDysInvalid()){
            holder.Diastolic.setTextColor(context.getColor(R.color.red));
        }
        else{
            holder.Diastolic.setTextColor(context.getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Systolic, Diastolic , HeartRate , Date;
        ImageView editButton , deleteButton;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            Systolic = itemView.findViewById(R.id.systolicText);
            Diastolic = itemView.findViewById(R.id.diastolicText);
            HeartRate = itemView.findViewById(R.id.heartText);
            Date = itemView.findViewById(R.id.dateText);

            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemPosition = getAdapterPosition();

                   // listener.onItemClick(getAdapterPosition());
                    //Intent intent = new Intent(MyAdapter.this, editActivity.class);

                    Context context1 = itemView.getContext();
                    Intent intent = new Intent(context1, editActivity.class);

                    context1.startActivity(intent);
                }
            });


            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

}
