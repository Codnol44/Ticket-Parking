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
import java.util.ArrayList;

public class ReglementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //On récupére la somme payée
        int total = Integer.parseInt(req.getParameter("total"));
        int paiement = Integer.parseInt(req.getParameter("paiement"));
        int sommerendue = (paiement - total);

        if(sommerendue != 0) {
            TicketManager tm;
            //Créer une liste de tickets via le Manager
            java.util.List<Ticket> ticketList = new ArrayList<>();
            try {
                tm = new TicketManager();
                ticketList = tm.eraseList();

            } catch (DALException | SQLException e) {
                System.out.println("Pb lors de la sélection liste !");
            }
        }

        // Affichage d'un message a l'utilisateur
        req.setAttribute("sommerendue", sommerendue);

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        //Pour aller à la JSP choix
        rd = req.getRequestDispatcher("WEB-INF/reglement.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}


