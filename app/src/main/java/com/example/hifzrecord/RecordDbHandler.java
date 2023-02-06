//package com.example.hifzrecord;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//
//public class RecordDbHandler  extends SQLiteOpenHelper {
//    public static final String Sabak = "Sabak";
//    public static final String Sabki = "Sabki";
//    public static final String Manzil = "Manzil";
//    public static final String id = "id";
//    public static final String StudentName = "StudentName";
//    public static final String date = "dateAdded";
//    public static final String RecordsTable = "RecordsTable";
//    public RecordDbHandler(@Nullable Context context) {
//        super(context, "HifzRecord.db", null, 4);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String RecordTableStatement = "CREATE TABLE "+ RecordsTable
//                + "( " + id + " Integer PRIMARY KEY AUTOINCREMENT, "
//                + StudentName + " Text, "
//                + Sabak + " Integer, "
//                + Sabki + " Integer, "
//                + Manzil + " Integer, "
//                + date + " Text) ";
//        Log.d("Ayesha", RecordTableStatement);
//
//        db.execSQL(RecordTableStatement);
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + RecordsTable);
//        onCreate(db);
//    }
//    public void AddRecord(StudentRecordBO sr) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(StudentName, sr.getStudentName());
//        cv.put(Sabak, sr.getSabak());
//        cv.put(Sabki, sr.getSabki());
//        cv.put(Manzil, sr.getManzil());
//        cv.put(date, sr.getDate());
//        db.insert(RecordsTable, null, cv);
//        db.close();
//    }
//    public ArrayList<StudentRecordBO> getAllRecords(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT " + StudentName + ", " + Sabak + ", " + Sabki + ", " + Manzil + ", " + date
//                + " FROM " + RecordsTable + " Where " + StudentName + " = '" + name + "';";
//
//        Cursor cursor = db.rawQuery(query, null);
////        Cursor cursor = db.rawQuery(query, null);
//        ArrayList<StudentRecordBO> recordArrayList = new ArrayList<>();
//
//        // moving our cursor to first position.
//        if (cursor.moveToFirst()) {
//            do {
//                recordArrayList.add(new StudentRecordBO(cursor.getString(0),
//                        cursor.getInt(1),
//                        cursor.getInt(2),
//                        cursor.getInt(3),
//                        cursor.getString(4)));
//            } while (cursor.moveToNext());
//
//        }
//        cursor.close();
//        db.close();
//        return recordArrayList;
//    }
//}
