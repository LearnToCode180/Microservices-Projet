package com.projet.soa.fournisseur.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "fournisseur")
public class Fournisseur {
    @Id
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
}
