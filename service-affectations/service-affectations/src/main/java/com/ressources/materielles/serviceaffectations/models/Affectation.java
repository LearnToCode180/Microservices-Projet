package com.ressources.materielles.serviceaffectations.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Affectation {

    @Id
    private Integer numAff;
    private Integer ressourceId;
    private Integer employeId;
    private long timestamp;


    public Affectation() {
        this.timestamp = System.currentTimeMillis();
    }

    public Affectation(Integer numAff, Integer ressourceId, Integer employeId) {
        this.numAff = numAff;
        this.ressourceId = ressourceId;
        this.employeId = employeId;
        this.timestamp = System.currentTimeMillis();
    }

    public Integer getNumAff() {
        return numAff;
    }

    public void setNumAff(Integer numAff) {
        this.numAff = numAff;
    }

    public Integer getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(Integer ressourceId) {
        this.ressourceId = ressourceId;
    }

    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }
}
