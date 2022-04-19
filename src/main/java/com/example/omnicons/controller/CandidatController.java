package com.example.omnicons.controller;

import com.example.omnicons.bean.Candidat;
import com.example.omnicons.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Candidat")
public class CandidatController {
    @GetMapping("/CandidatId/{idf}")
    public Candidat findCandidatByIdcandidat(@PathVariable long idf) {
        return candidatService.findCandidatByIdcandidat(idf);
    }
    @DeleteMapping("/CandidatId/{od}")
    public int deleteCandidatByIdcandidat(@PathVariable Long id) {
        return candidatService.deleteCandidatByIdcandidat(id);
    }
    @GetMapping("/")
    public List<Candidat> findAll() {
        return candidatService.findAll();
    }
    @PostMapping("/")
    public Candidat save(@RequestBody Candidat candidat) {
        return candidatService.save(candidat);
    }

    @PutMapping("/")
    public Candidat update(@RequestBody Candidat candidat) {
        return candidatService.update(candidat);
    }

    @Autowired
    CandidatService candidatService;

}
