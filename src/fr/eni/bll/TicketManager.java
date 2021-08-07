package fr.eni.bll;

import fr.eni.bo.Ticket;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.TicketDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class TicketManager {

    public static void addTicket(int numero, LocalDate date_jour, LocalTime heure_deb, LocalTime heure_fin, int montant) throws DALException, SQLException {
        TicketDAO ticketDAO = DAOFactory.getTicketDAO();
        Ticket tick = new Ticket(numero, date_jour, heure_deb, heure_fin, montant);
        ticketDAO.insertTick(tick);
    }

    public List<Ticket> displayTicket() throws DALException, SQLException{
        TicketDAO ticdao = DAOFactory.getTicketDAO();
        List<Ticket> ticketList = ticdao.selectTick();
        return ticketList;
    }

    public int calculTot(int montant, List<Ticket> ticketList) throws DALException, SQLException{
        int total = 0;
        TicketDAO ticdao = DAOFactory.getTicketDAO();
        total = ticdao.calculTotal(montant, ticketList);
        return total;
    }

    public List<Ticket> eraseList() throws DALException, SQLException{
        TicketDAO ticdao = DAOFactory.getTicketDAO();
        List<Ticket> ticketList = ticdao.deleteList();
        return ticketList;
    }

}
