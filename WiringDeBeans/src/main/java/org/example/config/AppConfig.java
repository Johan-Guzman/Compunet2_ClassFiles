package org.example.config;

import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

    @Bean(initMethod = "initRepo")
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }

    @Bean
    public CourseRepository courseRepository() {
        return new CourseRepository();
    }

    @Bean
    public StudentService studentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository) {
        return new StudentService(studentRepository, courseRepository);
    }

    @Bean
    public CourseService courseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        return new CourseService(courseRepository, studentRepository);
    }

}


