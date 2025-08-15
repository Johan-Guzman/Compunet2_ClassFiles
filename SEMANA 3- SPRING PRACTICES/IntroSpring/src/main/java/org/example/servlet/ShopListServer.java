package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import org.example.AppContext;
import org.example.services.ShopService;

import java.io.IOException;


@WebServlet("/shop")
public class ShopListServer extends HttpServlet {

    private ShopService shopService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        shopService = (ShopService) AppContext.getInstance().getBean("shopService");
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Este es un servlet </h1>");
    }


    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String compra = req.getParameter("compra");

        shopService.addShop(compra);
        int size = shopService.getShopList().size();
        System.out.println("El tamanio de la shop list es:   " + size);


        resp.sendRedirect("./");
    }
}
