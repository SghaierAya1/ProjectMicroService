package com.esprit.microservices.candidat.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Hotel implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nom , adresse ;
    private int categorie;
    private double prixParNuit;
    private boolean disponibilite;
    private String typeDeChambre;
    private Date dateDisponibleDebut;
    private Date dateDisponibleFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }


    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
    public String getTypeDeChambre() {
        return typeDeChambre;
    }

    public void setTypeDeChambre(String typeDeChambre) {
        this.typeDeChambre = typeDeChambre;
    }
    // Getter et Setter pour dateDisponibleDebut
    public Date getDateDisponibleDebut() {
        return dateDisponibleDebut;
    }

    public void setDateDisponibleDebut(Date dateDisponibleDebut) {
        this.dateDisponibleDebut = dateDisponibleDebut;
    }

    // Getter et Setter pour dateDisponibleFin
    public Date getDateDisponibleFin() {
        return dateDisponibleFin;
    }

    public void setDateDisponibleFin(Date dateDisponibleFin) {
        this.dateDisponibleFin = dateDisponibleFin;
    }

    public Hotel() {
        super();
    }

    public Hotel(String nom, String adresse, int categorie, double prixParNuit, boolean disponibilite, String typeDeChambre, Date dateDisponibleDebut, Date dateDisponibleFin) {
        super();
        this.nom = nom;
        this.adresse = adresse;
        this.categorie = categorie;
        this.prixParNuit = prixParNuit;
        this.disponibilite = disponibilite;
        this.typeDeChambre = typeDeChambre;
        this.dateDisponibleDebut = dateDisponibleDebut;
        this.dateDisponibleFin = dateDisponibleFin;
    }
}
