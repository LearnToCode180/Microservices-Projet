package com.projet.soabesoinservice.resource;

import com.projet.soabesoinservice.model.Besoin;
import com.projet.soabesoinservice.repository.BesoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BesoinController {


    @Autowired
    private BesoinRepository repository ;


    @PostMapping("/addBesoin")
    public String saveBesoin(@RequestBody Besoin besoin ){
        repository.save(besoin);
        return "Added besoin with id :" +besoin.getId();
    }

    @PostMapping("/alterBesoin")
    public String alterBesoin(@RequestBody List<Besoin> besoins ){
        for (Besoin besoin:besoins
             ) {
            besoin.setEstPrisEncharge(true);
            repository.save(besoin);
        }
        return "Besoins modified";
    }

    @GetMapping("/findAllBesoins")
    public List<Besoin> getBesoins() {
        return repository.findAll();
    }

    @GetMapping("/findBesoinsNonPrise")
    public List<Besoin> getBesoinsNonPrise() {
        List<Besoin> all = repository.findAll();
        List<Besoin> selected = new ArrayList<>();
        for (Besoin a:all) {
            if(a.getEstPrisEncharge().equals(false)){
                selected.add(a);
            }
        }
        return selected;
    }

    @GetMapping("/findBesoin/{id}")
    public Optional<Besoin> getBesoin(@PathVariable int id) {
        return repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBesoin(@PathVariable int id){
        repository.deleteById(id);
        return "besoin deleted with id :"+id;
    }
//    @DeleteMapping("/delete")
//    public Boolean deleteBesoinAll(){
//        repository.deleteAll();
//        return Boolean.TRUE;
//    }

}
