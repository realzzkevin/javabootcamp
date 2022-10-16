package com.company;

public class Student {
    private String name;
    private double gpa;

    public Student () {

    }
    public Student( String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public void setName( String n ) {
        this.name = n;
    }

    public void setGpa( double gpa) {
        this.gpa = gpa;
    }

    public void greet() {
        System.out.println("Hello, I am " + this.name + " and I have a "+ this.gpa);
    }
}
