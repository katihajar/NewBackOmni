package com.example.omnicons.services;

import com.example.omnicons.bean.Candidat;
import com.example.omnicons.Dao.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {
    @Autowired
    CandidatRepository candidatRepository;

    public Candidat findCandidatByIdcandidat(long idf) {
        return candidatRepository.findCandidatByIdcandidat(idf);
    }

    public int deleteCandidatByIdcandidat(Long id) {
        return candidatRepository.deleteCandidatByIdcandidat(id);
    }

    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }

    public  Candidat save(Candidat candidat) {

            return candidatRepository.save(candidat);

    }
    public Candidat update(Candidat candidat) {
        Candidat candidatUpd= findCandidatByIdcandidat(candidat.getIdcandidat());
        candidatUpd.setNomCandidat(candidat.getNomCandidat());
        return candidatRepository.save(candidatUpd);
    }
}
