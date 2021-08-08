package com.ressources.materielles.serviceressources.models;

import java.util.List;

public class ListRessFourn {

    private List<Ressource> Ressources;
    private List<Fournisseur> Fournisseurs;

    public ListRessFourn() {
    }

    public ListRessFourn(List<Ressource> ressources, List<Fournisseur> fournisseurs) {
        Ressources = ressources;
        Fournisseurs = fournisseurs;
    }

    public List<Ressource> getRessources() {
        return Ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        Ressources = ressources;
    }

    public List<Fournisseur> getFournisseurs() {
        return Fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        Fournisseurs = fournisseurs;
    }
}
