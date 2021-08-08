package com.ressources.materielles.serviceaffectations.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ressources.materielles.serviceaffectations.models.Besoin;
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
public class BesoinsInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackBesoins",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public ResponseEntity<List<Besoin>> getBesoins() {
        return restTemplate.exchange(
                "http://soa-besoin-service/findAllBesoins",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Besoin>>() {
                });
    }

    public ResponseEntity<List<Besoin>> getFallBackBesoins(){
        return new ResponseEntity<>(Arrays.asList(new Besoin(0,0,"Besoin Not Found !!",false)), HttpStatus.OK);
    }
}
