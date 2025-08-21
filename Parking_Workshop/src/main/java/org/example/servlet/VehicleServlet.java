package org.example.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Vehicle;
import org.example.service.VehicleService;

import java.io.IOException;

@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet { //PONER EL HTTPSERVLET PQ ES SERVLET

    private VehicleService vehicleservice;

    @Override
    public void init(ServletConfig config) throws ServletException {

        vehicleservice = AppContext.getInstance().getBean("vehicleService",VehicleService.class);
        vehicleservice.initRepository();
    }

    //EN EL JSP LOS NOMBRE QUE LE PONGAS A LAS ETIQUETAS EN EL HTML, DEBEN SER LOS MISMOS QE USASTE EN ESTE METODO O SINO NO TE GUARDAN, GUZ
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vehicleservice.addVehicle(new Vehicle(req.getParameter("id"), req.getParameter("placa"), req.getParameter("cilindraje"), req.getParameter("typeFuel"), req.getParameter("numberMotor"), req.getParameter("brand"), req.getParameter("model"), req.getParameter("")));
        System.out.println(vehicleservice.getVehicles());
        resp.sendRedirect("./");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vehicles", vehicleservice.getVehicles());
        req.getRequestDispatcher("/listVehicles.jsp").forward(req, resp);
    }

}
