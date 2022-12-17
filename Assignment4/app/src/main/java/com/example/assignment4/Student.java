package com.example.assignment4;

public class Student {
    private String name;
    private String CGPA;
    private String SGPA;

    public Student(String name, String CGPA, String SGPA) {
        this.name = name;
        this.CGPA = CGPA;
        this.SGPA = SGPA;
    }

    public String getName() {
        return name;
    }

    public String getCGPA() {
        return CGPA;
    }

    public String getSGPA() {
        return SGPA;
    }
}
