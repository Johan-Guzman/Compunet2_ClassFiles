package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.app.AppContext;
import org.example.model.Course;
import org.example.service.CourseService;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    private CourseService courseService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init(config);
        courseService = AppContext.getInstance().getBean("", CourseService.class);



    }
}