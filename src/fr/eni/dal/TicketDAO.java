package fr.eni.dal;

import fr.eni.bo.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO {

    void insertTick(Ticket tick) throws DALException, SQLException;

    List<Ticket> selectTick() throws DALException, SQLException;

    int calculTotal(int montant, List<Ticket> ticketList) throws DALException, SQLException;

    List<Ticket> deleteList() throws DALException, SQLException;

}
