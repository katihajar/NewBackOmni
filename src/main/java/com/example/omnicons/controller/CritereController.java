package com.example.omnicons.controller;


import com.example.omnicons.bean.Critere;
import com.example.omnicons.services.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Critere")
public class CritereController {


    @Autowired
    CritereService critereService;

    @GetMapping("/Criterie/{id}")
    public Critere findCritereByIdcritere(@PathVariable Long id) {
        return critereService.findCritereByIdcritere(id);
    }
    @GetMapping("/")
    public List<Critere> findAll() {
        return critereService.findAll();
    }
    @PostMapping("/")
    public Critere save(@RequestBody Critere critere) {
        return critereService.save(critere);
    }
@DeleteMapping("/idCritere/{integer}")
    public void deleteById(@PathVariable Long integer) {
        critereService.deleteById(integer);
    }
}
