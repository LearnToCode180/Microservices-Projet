package com.ressources.materielles.serviceressources.repositories;

import com.ressources.materielles.serviceressources.models.Ressource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends MongoRepository<Ressource, Integer> {
}
