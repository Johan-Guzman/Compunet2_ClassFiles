<%@ page import="org.example.service.DriverService" %>
<%@ page import="org.example.model.Driver" %>
<%@ page import="org.example.app.AppContext" %>
<!-- addConductor.jsp -->
<%
    DriverService driverService = AppContext.getInstance()
            .getBean("driverService", DriverService.class);


    for(Driver driver : driverService.getDrivers()){
        out.println("<p>"+driver.getName()+"</p>");
    }

%>

<form action="driver" method="post">
    <label>Nombre:</label>
    <input type="text" name="name" required><br>

    <label>Cargo:</label>
    <input type="text" name="occupation" required><br>

    <label>Tipo de Identificación:</label>
    <input type="text" name="typeId" required><br>

    <label>Número de Identificación:</label>
    <input type="text" name="numberIdentification" required><br>

    <input type="submit" value="Registrar Conductor">
</form>
