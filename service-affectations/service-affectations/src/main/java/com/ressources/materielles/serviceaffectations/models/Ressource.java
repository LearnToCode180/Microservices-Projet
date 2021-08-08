package com.ressources.materielles.serviceaffectations.models;

public class Ressource {

    private Integer numRes;
    private String nomR;
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
