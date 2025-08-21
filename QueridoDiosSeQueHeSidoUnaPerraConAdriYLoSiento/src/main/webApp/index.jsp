<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.app.AppContext" %>
<%@ page import="org.example.service.VeterinarianService" %>
<%@ page import="org.example.service.PetService" %>
<%@ page import="org.example.model.Veterinarian" %>
<%@ page import="org.example.model.Pet" %>
<%@ page import="java.util.List" %>

<%
    // Obtener servicios desde tu AppContext (igual que en tus servlets de ejemplo)
    VeterinarianService veterinarianService = AppContext.getInstance()
            .getBean("veterinarianService", VeterinarianService.class);

    PetService petService = AppContext.getInstance()
            .getBean("petService", PetService.class);

    // Lista de veterinarios para el combo y para el listado
    List<Veterinarian> vets = veterinarianService.getVets();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Vet Clinic</title>
</head>
<body>

<h1>Veterinarians & Pets</h1>

<!-- 1) AGREGAR VETERINARIO -->
<h2>Add Veterinarian</h2>
<form action="veterinarians" method="post">
    <label>ID:</label><br>
    <input type="text" name="id" required><br>

    <label>Name:</label><br>
    <input type="text" name="name" required><br>

    <label>License Number:</label><br>
    <input type="text" name="licenseNumber" required><br>

    <label>Specialty:</label><br>
    <select name="specialty" required>
        <option value="">-- Select --</option>
        <option value="CARDIOLOGIA">CARDIOLOGIA</option>
        <option value="MEDICINA GENERAL">MEDICINA GENERAL</option>
        <option value="CIRUGIA">CIRUGIA</option>
        <option value="PRACTICANTE">PRACTICANTE</option>
    </select><br><br>

    <input type="submit" value="Save Veterinarian">
</form>

<hr>

<!-- 2) AGREGAR MASCOTA (asignando veterinario) -->
<h2>Add Pet</h2>
<form action="pets" method="post">
    <label>Name:</label><br>
    <input type="text" name="name" required><br>

    <label>Estimated Birth Date:</label><br>
    <input type="text" name="estimatedBirthDate" placeholder="YYYY-MM-DD" required><br>

    <label>Type:</label><br>
    <select name="type" required>
        <option value="">-- Select --</option>
        <option value="PERRO">PERRO</option>
        <option value="GATO">GATO</option>
        <option value="PEZ">PEZ</option>
    </select><br>

    <label>Veterinarian:</label><br>
    <select name="veterinarianId" required>
        <option value="">-- Select --</option>
        <% for (Veterinarian v : vets) { %>
        <option value="<%= v.getId() %>">
            <%= v.getName() %> - Lic: <%= v.getLicenseNumber() %>
        </option>
        <% } %>
    </select><br><br>

    <input type="submit" value="Save Pet">
</form>

<hr>

<!-- 3) LISTA DE VETERINARIOS CON SUS MASCOTAS -->
<h2>Veterinarians List</h2>
<% if (vets == null || vets.isEmpty()) { %>
<p>No veterinarians registered yet.</p>
<% } else { %>
<% for (Veterinarian v : vets) { %>
<h3><%= v.getName() %></h3>
<p>License: <%= v.getLicenseNumber() %></p>
<p>Specialty: <%= v.getSpeciality() %></p>
<p>Pets:</p>
<ul>
    <%
        List<Pet> petsOfVet = petService.getPetsByVet(v.getId());
        if (petsOfVet == null || petsOfVet.isEmpty()) {
    %>
    <li>No pets assigned.</li>
    <%
    } else {
        for (Pet p : petsOfVet) {
    %>
    <li>
        <strong><%= p.getName() %></strong> - <%= p.getType() %> - Birth: <%= p.getBirthDate() %>
    </li>
    <%
            }
        }
    %>
</ul>
<hr>
<% } %>
<% } %>

</body>
</html>
