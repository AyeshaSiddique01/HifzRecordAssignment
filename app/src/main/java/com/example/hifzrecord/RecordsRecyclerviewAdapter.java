package com.example.hifzrecord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordsRecyclerviewAdapter extends RecyclerView.Adapter<RecordsRecyclerviewAdapter.MyVH> {

    List<StudentRecordBO> records;
    public RecordsRecyclerviewAdapter(List<StudentRecordBO> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public RecordsRecyclerviewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordsRecyclerviewAdapter.MyVH holder, int position) {
        holder.data=records.get(position);
        holder.date.setText(holder.data.getDate());
        holder.sabak.setText(String.valueOf(holder.data.getSabak()));
        holder.sabki.setText(String.valueOf(holder.data.getSabki()));
        holder.manzil.setText(String.valueOf(holder.data.getManzil()));
        holder.title.setText(String.valueOf(("Recent Record Of Student")));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView date, sabak, sabki, manzil, title;
        StudentRecordBO data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.StdName);
            sabak = itemView.findViewById(R.id.SabakCount);
            sabki = itemView.findViewById(R.id.SabkiCount);
            manzil = itemView.findViewById(R.id.ManzilCount);
            title = itemView.findViewById(R.id.textView);
        }
    }
}