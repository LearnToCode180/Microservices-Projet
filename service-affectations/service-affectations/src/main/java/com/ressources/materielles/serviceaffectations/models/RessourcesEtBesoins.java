package com.ressources.materielles.serviceaffectations.models;

import java.util.List;

public class RessourcesEtBesoins {

    private List<Ressource> Ressources;
    private List<Besoin> Besoins;

    public RessourcesEtBesoins() {
    }

    public RessourcesEtBesoins(List<Ressource> ressources, List<Besoin> besoins) {
        Ressources = ressources;
        Besoins = besoins;
    }

    public List<Ressource> getRessources() {
        return Ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        Ressources = ressources;
    }

    public List<Besoin> getBesoins() {
        return Besoins;
    }

    public void setBesoins(List<Besoin> besoins) {
        Besoins = besoins;
    }
}
