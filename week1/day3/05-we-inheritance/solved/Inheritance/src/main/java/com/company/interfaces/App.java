package com.company.interfaces;

public class App {

    public static void main(String[] args) {

        // Interface examples
        SchoolRecord record = new SchoolRecord();

        // This works because we can use an interface reference to point to an instance of a class
        // that implements that interface
        Auditable auditableRecord = record;
        Storable storableRecord = record;
    }
}
