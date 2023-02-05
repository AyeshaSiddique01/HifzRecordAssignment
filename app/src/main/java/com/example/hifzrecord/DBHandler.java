package com.example.hifzrecord;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public static final String name = "name";
    public static final String Sabak = "Sabak";
    public static final String Sabki = "Sabki";
    public static final String Manzil = "Manzil";
    public static final String id = "id";
    public static final String Database_Table = "Student_Table";

    public static final String StudentName = "StudentName";
    public static final String date = "date";
    public static final String Record_Table = "RecordsTable";
    String RecordTableStatement;
    public DBHandler(@Nullable Context context) {
        super(context, "HifzRecord.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentTableStatement = "CREATE TABLE " + Database_Table
                + "(" + id + " Integer PRIMARY KEY AUTOINCREMENT, "
                + name + " Text, "
                + Sabak + " Integer, "
                + Manzil + " Integer, "
                + Sabki + " Integer) ";
        RecordTableStatement = "CREATE TABLE RecordsTable("
                + id + " Integer PRIMARY KEY AUTOINCREMENT, "
                + StudentName + " Text, "
                + Sabak + " Integer, "
                + Sabki + " Integer, "
                + Manzil + " Integer, "
                + date + " Text);";
        db.execSQL(RecordTableStatement);
        db.execSQL(createStudentTableStatement);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Database_Table);
        db.execSQL("DROP TABLE IF EXISTS RecordsTable;");
        onCreate(db);
    }
    public void AddStudent(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertStudentQuery = "Insert into " + Database_Table
                + "(" + name + ", " + Sabak + ", " + Sabki + ", " + Manzil +") " +
                "Values('" + std.getName() + "', " + std.getSabak() + ", " + std.getSabki() +", " + std.getManzil() + ")";
        db.execSQL(insertStudentQuery);
    }
    public void AddRecord(StudentRecordBO sr) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertRecordQuery = "Insert into RecordsTable" +
                "(" + StudentName + ", " + Sabak + ", " + Sabki + ", " + Manzil + ", " + date +") " +
                "Values('" + sr.getStudentName() + "', " + sr.getSabak() + ", " + sr.getSabki() +", " + sr.getManzil() +", '" + sr.getDate() + "')";
//        Log.d("Ayesha", insertRecordQuery);
        Log.d("Ayesha", RecordTableStatement);
        db.execSQL(insertRecordQuery);
    }
    public ArrayList<Student> getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT name, Sabak, Sabki, Manzil FROM " + Database_Table, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new Student(cursorCourses.getString(0),
                        cursorCourses.getInt(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3)));
            } while (cursorCourses.moveToNext());

        }
        cursorCourses.close();
        return studentArrayList;
    }
    public ArrayList<StudentRecordBO> getAllRecords(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT StudentName, Sabak, Sabki, Manzil, Date FROM " + Record_Table + " Where " + StudentName + " like " + name, null);

        ArrayList<StudentRecordBO> recordArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                recordArrayList.add(new StudentRecordBO(cursorCourses.getString(0),
                        cursorCourses.getInt(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());

        }
        cursorCourses.close();
        return recordArrayList;
    }
}
