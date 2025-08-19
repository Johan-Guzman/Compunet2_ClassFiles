package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;



    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init(config);
        studentService = AppContext.getInstance().getBean("studentService", StudentService.class);




    }

    //JSP -> FORM QUE ENVIA LOS DATOS AL SGTE METODO
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentService.addStudent(new Student("","",""));
    }
}
