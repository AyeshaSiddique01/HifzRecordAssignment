package com.example.hifzrecord;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyVH> {
    ArrayList<Student> Students;
    ItemClickListener itemClickListener;
    int selectedPosition = -1;
    public RecyclerViewAdapter(ArrayList<Student> Std, ItemClickListener listener) {
        this.Students = Std;
        this.itemClickListener = listener;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyVH(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.stdName.setText(Students.get(position).getName());
        holder.sabak.setText(String.valueOf(Students.get(position).getSabak()));
        holder.sabki.setText(String.valueOf(Students.get(position).getSabki()));
        holder.manzil.setText(String.valueOf(Students.get(position).getManzil()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                int position = holder.getAdapterPosition();
                itemClickListener.onClick(position,Students.get(position));
                selectedPosition=position;
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return Students.size();
    }
    public class MyVH extends RecyclerView.ViewHolder {
        TextView stdName, sabak, sabki, manzil;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            stdName = itemView.findViewById(R.id.StdName);
            sabak = itemView.findViewById(R.id.SabakCount);
            sabki = itemView.findViewById(R.id.SabkiCount);
            manzil = itemView.findViewById(R.id.ManzilCount);
        }
        public void bind(final Student item) {
            stdName.setText(item.getName());
            sabak.setText(String.valueOf(item.getSabak()));
            sabki.setText(String.valueOf(item.getSabki()));
            manzil.setText(String.valueOf(item.getManzil()));

        }
    }
}
