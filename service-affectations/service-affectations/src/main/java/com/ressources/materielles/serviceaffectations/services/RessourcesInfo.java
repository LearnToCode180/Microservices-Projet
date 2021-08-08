package com.ressources.materielles.serviceaffectations.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ressources.materielles.serviceaffectations.models.Ressource;
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
public class RessourcesInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackRessources",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public ResponseEntity<List<Ressource>> getRessources() {
        return restTemplate.exchange(
                "http://service-ressources/Ressources/getAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ressource>>() {
                });
    }

    public ResponseEntity<List<Ressource>> getFallBackRessources(){
        return new ResponseEntity<>(Arrays.asList(new Ressource(0,"Ressource Not Found !!","")), HttpStatus.OK);
    }

}
