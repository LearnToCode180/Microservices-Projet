package com.ressources.materielles.serviceressources.services;

import com.ressources.materielles.serviceressources.models.Ressource;
import com.ressources.materielles.serviceressources.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    /**
     * Get all resources
     * @return List<Ressource>
     */
    public List<Ressource> findAll(){
        return ressourceRepository.findAll();
    }

    public Ressource getById(Integer id){
        return ressourceRepository.findById(id).get();
    }

    public Boolean addRessource(Ressource ressource){
        return ressourceRepository.save(ressource) == null ? false : true; // car la methode save() retourne l'objet ajouté
    }

    public void deleteRessource(Integer id){
        ressourceRepository.deleteById(id);
    }
}
