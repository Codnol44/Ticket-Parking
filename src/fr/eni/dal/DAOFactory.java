package fr.eni.dal;

public class DAOFactory {

    public static TicketDAO getTicketDAO() {
        TicketDAO tickdao = new TicketDAOJdbc();
        return tickdao;
    }
}
