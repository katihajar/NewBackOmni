package com.example.omnicons.controller;


import com.example.omnicons.bean.Campagne;
import com.example.omnicons.services.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Campagne")
public class CampagneController {



    @Autowired
    CampagneService campagneService;
    @GetMapping("/CampagneId/{id}")
    public Campagne findCampagneByIdcampagne(@PathVariable long id) {
        return campagneService.findCampagneByIdcampagne(id);
    }
    @GetMapping("/")
    public List<Campagne> findAll() {
        return campagneService.findAll();
    }
    @PostMapping("/")
    public Campagne save(@RequestBody Campagne campagne) {
        return campagneService.save(campagne);
    }
    @PutMapping("/")
    public Campagne update(@RequestBody Campagne campagne) {
        return campagneService.update(campagne);
    }
}
