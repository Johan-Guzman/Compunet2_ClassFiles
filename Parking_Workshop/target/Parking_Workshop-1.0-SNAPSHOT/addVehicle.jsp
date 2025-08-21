<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.app.AppContext" %>
<%@ page import="org.example.service.VehicleService" %>
<%@ page import="org.example.model.Vehicle" %>
<%@ page import="org.example.service.DriverService" %>
<%@ page import="org.example.model.Driver" %>
<%@ page import="java.util.List" %>

<%
    VehicleService vehicleService = AppContext.getInstance()
            .getBean("vehicleService", VehicleService.class);

    DriverService driverService = AppContext.getInstance()
            .getBean("driverService", DriverService.class);


%>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Vehículo</title>
</head>
<body>
<h1>Agregar Nuevo Vehículo</h1>

<form action="vehicles" method="post">
    <label>ID:</label>
    <input type="text" name="id" required><br>

    <label>Placa:</label>
    <input type="text" name="placa" required><br>

    <label>Cilindraje:</label>
    <input type="number" name="cilindraje" required><br>

    <label>Tipo de Combustible:</label>
    <select name="typeFuel" required>
        <option value="Gasolina">Gasolina</option>
        <option value="Diesel">Diesel</option>
        <option value="Eléctrico">Eléctrico</option>
        <option value="Híbrido">Híbrido</option>
    </select><br>

    <label>Número de Motor (12 caracteres):</label>
    <input type="text" name="numberMotor" maxlength="12" required><br>

    <label>Marca:</label>
    <input type="text" name="brand" required><br>

    <label>Año Modelo:</label>
    <input type="number" name="model" min="1900" max="2026" required><br>

    <label>Conductor:</label>
    <select name="conductorId" required>
        <option value="">-- Seleccione un conductor --</option>

        <%for (Driver driver : driverService.getDrivers() ) { %>
        <option value="<%= driver.getId() %>">
            <%= driver.getName() %> - <%= driver.getNumberIdentification() %>
        </option>
        <% } %>
    </select><br>

    <input type="submit" value="Agregar Vehículo">
</form>

<br>
<a href="vehicles">Ver todos los vehículos</a>
</body>
</html>