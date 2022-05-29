package com.example.omnicons.controller;


import com.example.omnicons.bean.Campagne;
import com.example.omnicons.services.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Campagne")
public class CampagneController {

    List files = new ArrayList();

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
    public Campagne save(@RequestBody Campagne campagne) throws IOException {
        return campagneService.save(campagne);
    }
    @PutMapping("/")
    public Campagne update(@RequestBody Campagne campagne) {
        return campagneService.update(campagne);
    }
    @GetMapping("/last5/")
    public List<Campagne> findByCritere() {
        return campagneService.findByCritere();
    }
    @GetMapping("/All/")
    public List<Campagne> findAllWithOrder() {
        return campagneService.findAllWithOrder();
    }

    @Transactional
    @DeleteMapping("/deletCamp/{id}")
    public int deleteCampagneByIdcampagne(@PathVariable long id) {
        return campagneService.deleteCampagneByIdcampagne(id);
    }



}
