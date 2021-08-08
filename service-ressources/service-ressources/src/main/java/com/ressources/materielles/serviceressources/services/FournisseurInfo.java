package com.ressources.materielles.serviceressources.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ressources.materielles.serviceressources.models.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FournisseurInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackFournisseur",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public ResponseEntity<List<Fournisseur>> getResponse() {
        return restTemplate.exchange(
                "http://service-fournisseurs/findAllFournisseurs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Fournisseur>>() {
                });
    }

    public ResponseEntity<List<Fournisseur>> getFallBackFournisseur(){
        return new ResponseEntity<>(Arrays.asList(new Fournisseur(0,"Fournisseur Not Found !!","","","","")), HttpStatus.OK);
    }
}
