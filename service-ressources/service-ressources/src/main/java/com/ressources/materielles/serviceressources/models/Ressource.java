package com.ressources.materielles.serviceressources.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;


@Document
public class Ressource {

    @Id
    private Integer numRes;

    @NotNull(message = "L'attribut nomRessource est requis")
    private String nomR;

    @NotNull(message = "L'attribut description est requis")
    private String desc;
    private long timestamp;

    public Ressource() {
        this.timestamp = System.currentTimeMillis();
    }

    public Ressource(Integer numRes, String nomR, String desc) {
        this.numRes = numRes;
        this.nomR = nomR;
        this.desc = desc;
        this.timestamp = System.currentTimeMillis();
    }

    public Integer getNumRes() {
        return numRes;
    }

    public void setNumRes(Integer numRes) {
        this.numRes = numRes;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
