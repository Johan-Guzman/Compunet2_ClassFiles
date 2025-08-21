package org.example.service;


import org.example.model.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;
    }


    public String addStudent(Student student) {
        String msj="";
        if(studentRepository.getStudents().contains(student)) {
            msj = "Student already exists";
            return msj;
        } else {
            studentRepository.addStudent(student);
            msj = "Student succesfully Saved";
            return msj;
        }

    }


    public ArrayList<Student> getStudents() {
        return studentRepository.getStudents();
    }




}
