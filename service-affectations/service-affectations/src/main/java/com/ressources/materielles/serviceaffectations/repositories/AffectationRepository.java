package com.ressources.materielles.serviceaffectations.repositories;

import com.ressources.materielles.serviceaffectations.models.Affectation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository extends MongoRepository<Affectation, Integer> {
}
