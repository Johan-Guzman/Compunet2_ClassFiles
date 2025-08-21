package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Pet;
import org.example.model.Veterinarian;
import org.example.repository.VeterinarianRepository;
import org.example.service.PetService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/pets")
public class PetServlet extends HttpServlet {

    private PetService petService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        petService = AppContext.getInstance().getBean("petService",PetService.class);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException{
      req.setAttribute("pets", petService.getPets());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String estimatedBirthDate = req.getParameter("estimatedBirthDate");
        String type = req.getParameter("type");
        String veterinarianId = req.getParameter("veterinarianId");

        Pet pet = new Pet(name, estimatedBirthDate, type, veterinarianId);
        petService.addPet(pet);
        resp.sendRedirect("./");

        }
}


