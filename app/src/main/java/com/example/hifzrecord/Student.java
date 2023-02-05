package com.example.hifzrecord;

public class Student {
    int id;
    String name;
    int Sabak;
    int Sabki;
    int Manzil;

    public Student(String name, int sabak, int sabki, int manzil) {
        this.name = name;
        Sabak = sabak;
        Sabki = sabki;
        Manzil = manzil;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSabak() {
        return Sabak;
    }

    public void setSabak(int sabak) {
        Sabak = sabak;
    }

    public int getSabki() {
        return Sabki;
    }

    public void setSabki(int sabki) {
        Sabki = sabki;
    }

    public int getManzil() {
        return Manzil;
    }

    public void setManzil(int manzil) {
        Manzil = manzil;
    }
}
