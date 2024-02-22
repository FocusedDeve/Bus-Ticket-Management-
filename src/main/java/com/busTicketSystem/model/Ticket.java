package com.busTicketSystem.model;

public class Ticket {

    private int id;
    private int idUtilisateur;
    private String codeQR;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public boolean isUtilise() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

    private boolean utilise;

    public Ticket(int id, int idUtilisateur, String codeQR, boolean utilise) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.codeQR = codeQR;
        this.utilise = utilise;
    }

    // Getters et setters
    // ...
}
