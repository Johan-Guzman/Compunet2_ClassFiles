package org.example.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Veterinarian;
import org.example.service.VeterinarianService;

import java.io.IOException;

@WebServlet("/veterinarians")
public class VeterinarainServlet extends HttpServlet {

    private VeterinarianService veterinarianService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        veterinarianService = AppContext.getInstance().getBean("veterinarianService",VeterinarianService.class);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Muestra el JSP del formulario
        req.setAttribute("veterinarians", veterinarianService.getVets());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lee parámetros del form
        String id=req.getParameter("id");
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("licenseNumber");
        String specialty = req.getParameter("specialty");

        Veterinarian vet = new Veterinarian(
                id,
                name,
                licenseNumber,
                specialty
        );

            veterinarianService.addVet(vet);
            resp.sendRedirect("./");


    }
}
