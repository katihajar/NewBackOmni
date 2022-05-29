package com.example.omnicons.controller;

import com.example.omnicons.Dao.CandidatResponseCritereDao;
import com.example.omnicons.bean.CandidatResponseCritere;
import com.example.omnicons.services.CandidatResponseCritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CandidatRespCritere")
public class CandidatResponseCritereController {
    @Autowired
    CandidatResponseCritereService candidatResponseCritereService;

    @PostMapping("/")
    public CandidatResponseCritere save(@RequestBody CandidatResponseCritere entity) {
        return candidatResponseCritereService.save(entity);
    }
    @GetMapping("/idCand/{id}/idCamp/{ids}")
    public List<CandidatResponseCritere> findByCandidatIdcandidatAndCampagneIdcampagne(@PathVariable Long id, @PathVariable long ids) {
        return candidatResponseCritereService.findByCandidatIdcandidatAndCampagneIdcampagne(id, ids);
    }
}
