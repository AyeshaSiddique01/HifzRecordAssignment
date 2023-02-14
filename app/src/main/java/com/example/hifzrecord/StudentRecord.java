package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentRecord extends AppCompatActivity {

    Button AddNewRecord, ViewAllRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);
        Intent i = getIntent();
        int position = i.getIntExtra("Student", 0);

        AddNewRecord = findViewById(R.id.AddNewRecord);
        ViewAllRecord = findViewById(R.id.ViewRecentRecord);

        AddNewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentRecord.this, AddNewStudentRecord.class);
                intent.putExtra("Student", position);
                startActivity(intent);
            }
        });
        ViewAllRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentRecord.this, ViewAllRecords.class);
                intent.putExtra("Student", position);
                startActivity(intent);
            }
        });
    }

}