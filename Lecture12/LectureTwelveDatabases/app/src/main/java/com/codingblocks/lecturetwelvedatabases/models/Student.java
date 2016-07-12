package com.codingblocks.lecturetwelvedatabases.models;

/**
 * Created by championswimmer on 12/07/16.
 */
public class Student {
    int id;
    String name;
    int studentClass;
    int age;

    public Student(int id, String name, int studentClass, int age) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public int getAge() {
        return age;
    }
}
