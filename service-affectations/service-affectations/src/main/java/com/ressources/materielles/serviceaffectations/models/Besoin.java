package com.ressources.materielles.serviceaffectations.models;

import org.springframework.data.annotation.Id;

public class Besoin {

    private int id;
    private int quantité;
    private String name;
    private Boolean estPrisEncharge;


    public Besoin(int id, int quantité, String name, Boolean estPrisEncharge) {
        this.id = id;
        this.quantité = quantité;
        this.name = name;
        this.estPrisEncharge = estPrisEncharge;

    }

    public Besoin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEstPrisEncharge() {
        return estPrisEncharge;
    }

    public void setEstPrisEncharge(Boolean estPrisEncharge) {
        this.estPrisEncharge = estPrisEncharge;
    }
}


