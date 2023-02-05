package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class AddNewStudentPage extends AppCompatActivity {
    EditText name, sabak, manzil;
    Button addbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student_page);
        Intent intent = getIntent();

        DBHandler db = new DBHandler(this);

        name = findViewById(R.id.NameEntered);
        sabak = findViewById(R.id.EnteredSabak);
        manzil = findViewById(R.id.ManzilEntered);
        addbtn = findViewById(R.id.AddStudentBtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student std = new Student(name.getText().toString(), Integer.parseInt(sabak.getText().toString()), Integer.parseInt(sabak.getText().toString()) - 1, Integer.parseInt(manzil.getText().toString()));
                db.AddStudent(std);

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.studentaddedmsj,
                        (ViewGroup) findViewById(R.id.AddStudent_toast_viewgroup));

                TextView text = layout.findViewById(R.id.AddedStudentToast);
                text.setText("Student Added");
                Toast toast = new Toast(AddNewStudentPage.this);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 800);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}