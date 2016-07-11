package com.codingblocks.lecturefiveadapters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by championswimmer on 21/06/16.
 */
public class Courses {

    public static class Course {
        String name;
        int capacity;
        int enrollment;

        public Course(String name, int capacity, int enrollment) {
            this.name = name;
            this.capacity = capacity;
            this.enrollment = enrollment;
        }
    }

    public static ArrayList<Course> getCourses () {
        ArrayList<Course> courses = new ArrayList<>(100);

        for (int i = 2014; i < 2024; i ++) {
            courses.add(new Course("C++" + i, 50, 40));
            courses.add(new Course("Java" + i, 50, 32));
            courses.add(new Course("Python" + i, 50, 34));
            courses.add(new Course("PHP" + i, 50, 42));
            courses.add(new Course("Perl" + i, 50, 25));
            courses.add(new Course("Javascript" + i, 50, 27));
            courses.add(new Course("Go" + i, 50, 37));
            courses.add(new Course("Shell" + i, 50, 22));
            courses.add(new Course("Lua" + i, 50, 29));
            courses.add(new Course("Basic" + i, 50, 45));
        }

        return courses;
    }
}
