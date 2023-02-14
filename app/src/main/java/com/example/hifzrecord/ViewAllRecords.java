package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAllRecords extends AppCompatActivity {
    ArrayList<StudentRecordBO> records;
    RecyclerView rv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_records);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Student", 0);


        DBHandler db = new DBHandler(this);
        String studentName = db.getAllStudents().get(position).getName();

        records = db.getAllRecords(studentName);

        rv = findViewById(R.id.RecordsRecyclerView);

        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager((ViewAllRecords.this));
        rv.setLayoutManager(layoutManager);
        adapter = new RecordsRecyclerviewAdapter(records);
        rv.setAdapter(adapter);

    }
}