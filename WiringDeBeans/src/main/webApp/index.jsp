<%@ page import="org.example.app.AppContext" %>
<%@ page import="org.example.service.StudentService" %>
<%@ page import="org.example.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Estudiantes</title>
</head>
<body>
<h1>Registro de Estudiantes</h1>

<!-- Formulario para agregar un estudiante -->
<form action="index.jsp" method="post">
    <label for="id">ID:</label>
    <input type="text" name="id" id="id" required><br><br>

    <label for="name">Nombre:</label>
    <input type="text" name="name" id="name" required><br><br>

    <label for="courseId">Curso ID:</label>
    <input type="text" name="courseId" id="courseId" required><br><br>

    <button type="submit">Guardar Estudiante</button>
</form>

<hr>

<h2>Lista de Estudiantes</h2>
<%
    StudentService studentService = AppContext.getInstance().getBean("studentService", StudentService.class);

    // Procesar el formulario si llega un POST
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String courseId = request.getParameter("courseId");

        Student newStudent = new Student(id, name, courseId);

        studentService.addStudent(newStudent);
    }

    // Mostrar lista de estudiantes
    for (Student student : studentService.getStudents()) {
        out.println("<p>ID: " + student.getId() +
                " | Nombre: " + student.getName() +
                " | Curso: " + student.getCourseId() + "</p>");
    }
%>
</body>
</html>