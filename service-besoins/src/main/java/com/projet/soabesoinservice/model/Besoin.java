package com.projet.soabesoinservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Besoin")
public class Besoin {
    @Id
    private int id;
    private int quantité;
    private String name;
    private Boolean estPrisEncharge;

    public Besoin(int id, int quantité, String name, Boolean estPrisEncharge) {
        this.id = id;
        this.quantité = quantité;
        this.name = name;
        this.estPrisEncharge=estPrisEncharge;

 }
}