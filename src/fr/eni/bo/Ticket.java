package fr.eni.bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {

    private int numero;
    private LocalDate date_jour;
    private LocalTime heure_deb;
    private LocalTime heure_fin;
    private int montant;

    public Ticket(int numero, LocalDate date_jour, LocalTime heure_deb, LocalTime heure_fin, int montant){
        this.numero = numero;
        this.date_jour = date_jour;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.montant = montant;
    }

    public Ticket(LocalDate date_jour, LocalTime heure_deb, LocalTime heure_fin, int montant) {
        this.date_jour = date_jour;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.montant = montant;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int id) {
        this.numero = numero;
    }

    public LocalDate getDate_jour() {
        return date_jour;
    }

    public void setDate_jour(LocalDate date_jour) {
        this.date_jour = date_jour;
    }

    public LocalTime getHeure_deb() { return heure_deb; }

    public void setHeure_deb(LocalTime heure_deb) {
        this.heure_deb = heure_deb;
    }

    public LocalTime getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(LocalTime heure_fin) {
        this.heure_fin = heure_fin;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

}
