package com.ressources.materielles.serviceaffectations.services;

import com.ressources.materielles.serviceaffectations.models.Affectation;
import com.ressources.materielles.serviceaffectations.repositories.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationService {

    @Autowired
    private AffectationRepository affectationRepository;

    public List<Affectation> getAllAffectations(){
        return affectationRepository.findAll();
    }

    public Affectation getAffectationkById(Integer id){
        return affectationRepository.findById(id).get();
    }

    public Affectation addAffectation(Affectation affectation){
        return affectationRepository.save(affectation);
    }

    public void deleteAffectation(Integer id){
        affectationRepository.deleteById(id);
    }
}
