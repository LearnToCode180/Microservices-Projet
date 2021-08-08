package com.ressources.materielles.serviceressources.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ressources.materielles.serviceressources.models.Fournisseur;
import com.ressources.materielles.serviceressources.models.ListRessFourn;
import com.ressources.materielles.serviceressources.models.Ressource;
import com.ressources.materielles.serviceressources.services.FournisseurInfo;
import com.ressources.materielles.serviceressources.services.RessourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Ressources")
public class RessourceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RessourceService ressourceService;

    @Autowired
    FournisseurInfo fournisseurInfo;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"","/"})
    public ListRessFourn getRessourcesFournisseurs(){

        List<Ressource> Ressources = ressourceService.findAll();

        ResponseEntity<List<Fournisseur>> response = fournisseurInfo.getResponse();

        List<Fournisseur> Fournisseurs = response.getBody();


        ListRessFourn RessourcesFournisseurs = new ListRessFourn(Ressources, Fournisseurs);

        log.info("-------Récupération de la liste des Ressources !!-------");

        return RessourcesFournisseurs;
    }

    @RequestMapping(value = {"/getAll"})
    public List<Ressource> getAllRessources(){
        List<Ressource> Ressources = ressourceService.findAll();
        return Ressources;
    }

    @RequestMapping(value = "/{ressourceId}")
    public ResponseEntity<Ressource> getRessource(@PathVariable Integer ressourceId){
        Ressource ressource = ressourceService.getById(ressourceId);
        return new ResponseEntity<>(ressource, HttpStatus.OK);

    }

    @PostMapping(value = {"/add"})
    public Boolean addRessource(@Valid @RequestBody Ressource ressource){
        return ressourceService.addRessource(ressource);
    }

    @DeleteMapping(value = "/{ressourceId}")
    public ResponseEntity<Void> deleteRessource(@PathVariable("ressourceId") Integer id){
        ressourceService.deleteRessource(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
