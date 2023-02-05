package com.example.hifzrecord;

import androidx.annotation.NonNull;

public class StudentRecordBO {
    String StudentName;
    int Sabak;
    int Sabki;
    int Manzil;
    String Date;

    public StudentRecordBO(String studentName, int sabak, int sabki, int manzil, String date) {
        StudentName = studentName;
        this.Sabak = sabak;
        this.Sabki = sabki;
        this.Manzil = manzil;
        Date = date;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getSabak() {
        return Sabak;
    }

    public void setSabak(int sabak) {
        this.Sabak = sabak;
    }

    public int getSabki() {
        return Sabki;
    }

    public void setSabki(int sabki) {
        this.Sabki = sabki;
    }

    public int getManzil() {
        return Manzil;
    }

    public void setManzil(int manzil) {
        this.Manzil = manzil;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
