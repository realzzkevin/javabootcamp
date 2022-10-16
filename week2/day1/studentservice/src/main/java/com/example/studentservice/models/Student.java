package com.example.studentservice.models;

public class Student {
    private String name;
    private int graduationYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Student(String name, int graduationYear) {
        this.name = name;
        this.graduationYear = graduationYear;
    }


}
