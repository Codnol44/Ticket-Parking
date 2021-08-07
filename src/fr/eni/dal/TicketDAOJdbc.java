package fr.eni.dal;

import fr.eni.bo.Ticket;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOJdbc implements TicketDAO{

    //1-Ajout d'un ticket
    public void insertTick(Ticket tick) throws SQLException {

        String INSER_TICK = "INSERT into TICKETS(numero, date_jour, heure_deb, heure_fin, montant) VALUES(?,?,?,?,?)";

        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(INSER_TICK);
        ) {

            //On remplace les ? dans la requete
            pstt.setInt(1, tick.getNumero());
            pstt.setDate(2, java.sql.Date.valueOf(tick.getDate_jour()));
            pstt.setTime(3, java.sql.Time.valueOf(tick.getHeure_deb()));
            pstt.setTime(4, java.sql.Time.valueOf(tick.getHeure_fin()));
            pstt.setInt(5, tick.getMontant());

            //J'exécute la requête
            pstt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //2-Affichage de la facture
    public List<Ticket> selectTick() throws DALException, SQLException {

        String DISPLAY_FACTURE = "SELECT t.numero, t.date_jour, t.heure_deb, t.heure_fin, t.montant FROM TICKETS t";

        List<Ticket> ticketList = new ArrayList<>();
        try (
                //On lance la connexion
                Connection connection = ConnectionProvider.getConnection();
                Statement stt = connection.createStatement();
        ) {
            //J'exécute la requête
            ResultSet rs = stt.executeQuery(DISPLAY_FACTURE);
            //Conversion SQL en LocalDate :
            LocalDate date_jour = null;
            LocalTime heure_deb = null;
            LocalTime heure_fin = null;
            //On ajoute les paramètres de son objet avec le get
            while (rs.next()) {
                int numero = rs.getInt(1);
                //On rebascule le sql en localdate ou localtime !
                java.sql.Date mySqlDate = rs.getDate(2);
                date_jour = mySqlDate.toLocalDate();
                java.sql.Time mySqlTime = rs.getTime(3);
                heure_deb = mySqlTime.toLocalTime();
                mySqlTime = rs.getTime(4);
                heure_fin = mySqlTime.toLocalTime();
                int montant = rs.getInt(5);
                ticketList.add(new Ticket(rs.getInt("numero"), date_jour, heure_deb, heure_fin, rs.getInt("montant")));
            }
        }
        return ticketList;
    }

    //3-Calcul du total de la facture
    public int calculTotal(int montant, List<Ticket> ticketList) throws DALException, SQLException {
        int total = 0;
        for (Object item : ticketList) {
            total = montant + total;
        }
        return total;
    }

    //4-Suppression de la facture
    public List<Ticket> deleteList() throws DALException, SQLException {

        String DELETE_LIST = "TRUNCATE TABLE TICKETS";

        List<Ticket> ticketList = new ArrayList<>();

        try (
                //On remplace la connexion initiale
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(DELETE_LIST);
        ) {
            pstt.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("Pb lors de la suppression facture !");
        }
        return ticketList;
    }

}
