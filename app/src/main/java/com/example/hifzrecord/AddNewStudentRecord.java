package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewStudentRecord extends AppCompatActivity {
    EditText Date, sabak, manzil;
    Button addbtn;
    ArrayList<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student_record);
        Intent intent = getIntent();
        int position = intent.getIntExtra("Student", 0);
        DBHandler db = new DBHandler(this);
        students = db.getAllStudents();

        Date = findViewById(R.id.DateRecording);
        sabak = findViewById(R.id.SabakRecording);
        manzil = findViewById(R.id.ManzilRecording);
        addbtn = findViewById(R.id.AddRecordBtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentRecordBO studentRecordBO = new StudentRecordBO(students.get(position).getName(), Integer.parseInt(sabak.getText().toString()), Integer.parseInt(sabak.getText().toString()) - 1, Integer.parseInt(manzil.getText().toString()), Date.getText().toString());
                db.AddRecord(studentRecordBO);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.studentaddedmsj,
                        (ViewGroup) findViewById(R.id.AddStudent_toast_viewgroup));

                TextView text = layout.findViewById(R.id.AddedStudentToast);
                text.setText("Record Added");
                Toast toast = new Toast(AddNewStudentRecord.this);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 800);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

    }
}