package org.example.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Driver;
import org.example.service.DriverService;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/driver")
public class DriverServlet extends HttpServlet {

    private DriverService driverService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        driverService = AppContext.getInstance().getBean("driverService", DriverService.class);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>" + driverService.getDrivers());
        driverService.addDriver(
                new Driver(UUID.randomUUID().toString(),
                        req.getParameter("name"),
                        req.getParameter("numberIdentification"),
                        req.getParameter("occupation"),
                        req.getParameter("typeId")
        )
                //EL ORDEN DE LOS REQ, DEBE SER IGUAL A LOS DEL CONSTRUCTOR SINO LE GUARDA CUALQUIER PACHOTADA

        );
        System.out.println(driverService.getDrivers());
        resp.sendRedirect("./");
    }



}
