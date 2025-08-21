<%@ page import="org.example.service.VehicleService" %>
<%@ page import="org.example.app.AppContext" %>
<%@ page import="org.example.model.Vehicle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20/08/2025
  Time: 5:06 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%
    VehicleService vehicleService = AppContext.getInstance()
            .getBean("vehicleService", VehicleService.class);
    List<Vehicle> vehicles = vehicleService.getVehicles();
%>

<html>
<head>
    <title>Lista de Vehículos</title>
</head>
<body>
<h2>Vehículos Registrados</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Placa</th>
        <th>Cilindraje</th>
        <th>Combustible</th>
        <th>Número Motor</th>
        <th>Marca</th>
        <th>Modelo</th>
    </tr>

    <% for(Vehicle vehicle : vehicles) { %>
    <tr>
        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getPlaca() %></td>
        <td><%= vehicle.getCilindraje() %></td>
        <td><%= vehicle.getTypeFuel() %></td>
        <td><%= vehicle.getNumberMotor() %></td>
        <td><%= vehicle.getBrand() %></td>
        <td><%= vehicle.getModel() %></td>
    </tr>
    <% } %>
</table>

<a href="addVehicle.jsp">Agregar Vehículo</a>
</body>
</html>