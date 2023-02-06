package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentRecord extends AppCompatActivity {
    List<StudentRecordBO> records;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item);
        Intent intent = getIntent();
        int position = intent.getIntExtra("Student", 0);
        //db
        DBHandler db = new DBHandler(this);
//        RecordDbHandler recordDbHandler = new RecordDbHandler(ViewStudentRecord.this);
        String studentName = db.getAllStudents().get(position).getName();
        records = db.getAllRecords(studentName);
        recyclerView = findViewById(R.id.StudentsRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ViewStudentRecord.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecordsRecyclerviewAdapter(records) ;
        recyclerView.setAdapter(adapter);

    }
}