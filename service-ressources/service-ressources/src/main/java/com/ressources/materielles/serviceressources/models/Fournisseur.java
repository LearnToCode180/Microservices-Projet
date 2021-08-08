package com.ressources.materielles.serviceressources.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Fournisseur {

    private int id;
    private String Username;
    private String Nom;
    private String Adresse;
    private String Tel;
    private String Mdp;

    public Fournisseur() {
    }

    public Fournisseur(int id, String username, String nom, String adresse, String tel, String mdp) {
        this.id = id;
        Username = username;
        Nom = nom;
        Adresse = adresse;
        Tel = tel;
        Mdp = mdp;
    }

    public String getNom() {
        return Nom;
    }

    public int getId() {
        return id;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getTel() {
        return Tel;
    }

    public String getUsername() {
        return Username;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }
}

