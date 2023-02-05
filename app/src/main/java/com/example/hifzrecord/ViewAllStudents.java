package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewAllStudents extends AppCompatActivity {
    ArrayList<Student> Students = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ItemClickListener itemClickListener;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);
        Intent intent = getIntent();

        DBHandler db = new DBHandler(this);
        Students = db.getAllStudents();

        recyclerView = findViewById(R.id.StudentsRecyclerView);

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(int position, Student value) {
                Intent intent = new Intent(ViewAllStudents.this, StudentRecord.class);
                intent.putExtra("Student", position);
                startActivity(intent);
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(Students, itemClickListener);
        recyclerView.setAdapter(adapter);
    }
}