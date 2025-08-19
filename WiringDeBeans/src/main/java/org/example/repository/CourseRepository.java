package org.example.repository;

import org.example.model.Course;

import java.util.ArrayList;

public class CourseRepository {
    private ArrayList<Course> courses;

    public void AddCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
