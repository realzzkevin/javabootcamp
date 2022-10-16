package com.company;

public class App {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName("kevin");
        student1.setGpa(2.7);

        student2.setName("Adam");
        student2.setGpa(3.5);

        student1.greet();
        student2.greet();

        Student student3 = new Student("Doc", 4.0);
        student3.greet();
    }
}
