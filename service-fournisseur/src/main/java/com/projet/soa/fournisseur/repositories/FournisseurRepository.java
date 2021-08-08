package com.projet.soa.fournisseur.repositories;

import com.projet.soa.fournisseur.models.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FournisseurRepository extends MongoRepository<Fournisseur, Integer> {
}
