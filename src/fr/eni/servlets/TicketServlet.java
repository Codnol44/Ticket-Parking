package fr.eni.servlets;

import fr.eni.bll.TicketManager;
import fr.eni.bo.Ticket;
import fr.eni.dal.DALException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import static java.time.temporal.ChronoUnit.MINUTES;

public class TicketServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("WEB-INF/ticket.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //On récupére les élémts du ticket
        int numero = Integer.parseInt(req.getParameter("numero"));
        LocalDate date_jour = LocalDate.parse(req.getParameter("date_jour"));
        LocalTime heure_deb = LocalTime.parse(req.getParameter("heuredeb"));
        LocalTime heure_fin = LocalTime.parse(req.getParameter("heurefin"));

        //On calcule la diff entre les 2 deux Time
        long minutesBetween = ChronoUnit.MINUTES.between(heure_deb,heure_fin);
        int montant = (int) (minutesBetween * 0.03);

        //A partir des paramètres, créer une instance de ticket via TicketManager
        TicketManager tm;
        try {
            tm = new TicketManager();
            tm.addTicket(numero, date_jour, heure_deb, heure_fin, montant);

        } catch (DALException | SQLException e) {
            e.printStackTrace();
        }

        //Créer une liste de tickets via le Manager
        java.util.List<Ticket> ticketList = new ArrayList<>();
        try {
            tm = new TicketManager();
            ticketList = tm.displayTicket();

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la sélection liste !");
        }

        //La servlet envoie l'info à la JSP !
        req.setAttribute("ticketList", ticketList);

        //Calcul du total de la facture
        int total = 0;
        try {
            tm = new TicketManager();
            total = tm.calculTot(montant, ticketList);

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la sélection liste !");
        }

        //La servlet envoie l'info à la JSP !
        req.setAttribute("total", total);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/facture.jsp");
        rd.forward(req, resp);

    }

}
