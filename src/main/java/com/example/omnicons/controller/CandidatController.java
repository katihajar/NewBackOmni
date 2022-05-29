package com.example.omnicons.controller;

import com.example.omnicons.bean.Candidat;
import com.example.omnicons.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Candidat")
public class CandidatController {
    @GetMapping("/ListCandidatId/{idf}")
    public List<Candidat> findCandidatByCampagneIdcampagne(@PathVariable long idf) {
        return candidatService.findCandidatByCampagneIdcampagne(idf);
    }
    @GetMapping("/ListCandidatId/{idf}/reussite/{a}")
    public List<Candidat> findCandidatByCampagneIdcampagneAndReussiSelectionAuto(@PathVariable long idf,@PathVariable Boolean a) {
        return candidatService.findCandidatByCampagneIdcampagneAndReussiSelectionAuto(idf, a);
    }

    @GetMapping("/Candidatprenom/{pre}/nom/{nom}")
    public Candidat findCandidatByprenomCandidatAndNomCandidat(@PathVariable String pre,@PathVariable String nom) {
        return candidatService.findCandidatByprenomCandidatAndNomCandidat(pre, nom);
    }
    @GetMapping("/Candidatprenom/{pre}/nom/{nom}/id/{id}")
    public Candidat findCandidatByprenomCandidatAndNomCandidatAndCampagneIdcampagne(@PathVariable String pre,@PathVariable String nom,@PathVariable Long id) {
        return candidatService.findCandidatByprenomCandidatAndNomCandidatAndCampagneIdcampagne(pre, nom, id);
    }

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
