package org.example.service;


import org.example.model.Student;
import org.example.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository;
    private  CourseService courseService;

    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
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

}
