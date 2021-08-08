package com.ressources.materielles.serviceaffectations.controllers;

import com.ressources.materielles.serviceaffectations.models.*;
import com.ressources.materielles.serviceaffectations.services.AffectationService;
import com.ressources.materielles.serviceaffectations.services.BesoinsInfo;
import com.ressources.materielles.serviceaffectations.services.RessourcesInfo;
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
@RequestMapping("/Affectations")
public class AffectationController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AffectationService affectationService;

    @Autowired
    RessourcesInfo ressourcesInfo;

    @Autowired
    BesoinsInfo BesoinsInfo;



    @PostMapping(value = {"/add"})
    public ResponseEntity<RessourcesEtBesoins> addAffectation(@Valid @RequestBody Affectation affectation){

        ResponseEntity<List<Ressource>> response1 = ressourcesInfo.getRessources();

        List<Ressource> Ressources = response1.getBody();

        ResponseEntity<List<Besoin>> response2 = BesoinsInfo.getBesoins();

        List<Besoin> Besoins = response2.getBody();

        RessourcesEtBesoins RB = new RessourcesEtBesoins(Ressources, Besoins);


        Affectation affectation1 = affectationService.addAffectation(affectation);
        System.out.println("Affectation bien ajoutée");
        return new ResponseEntity<>(RB, HttpStatus.CREATED);
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<Affectation>> getAllAffectations(){
        List<Affectation> Affectations = affectationService.getAllAffectations();
        log.info("Récupération de la liste des affectations");
        return new ResponseEntity<>(Affectations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Affectation> getAffectationById(@PathVariable("id") Integer id){
        Affectation Affectation = affectationService.getAffectationkById(id);
        return new ResponseEntity<>(Affectation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectation(@PathVariable("id") Integer id){
        affectationService.deleteAffectation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }







}
