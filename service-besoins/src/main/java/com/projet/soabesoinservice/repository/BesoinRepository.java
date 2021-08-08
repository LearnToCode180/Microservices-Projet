package com.projet.soabesoinservice.repository;

import com.projet.soabesoinservice.model.Besoin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BesoinRepository extends MongoRepository<Besoin,Integer>   {


}
