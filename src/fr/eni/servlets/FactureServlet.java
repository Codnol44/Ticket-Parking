package fr.eni.servlets;

import fr.eni.bll.TicketManager;
import fr.eni.bo.Ticket;
import fr.eni.dal.DALException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FactureServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        //Pour aller à la JSP choix !
        rd = req.getRequestDispatcher("WEB-INF/facture.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
