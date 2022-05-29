package com.example.omnicons.services;

import com.example.omnicons.bean.Campagne;
import com.example.omnicons.bean.Candidat;
import com.example.omnicons.Dao.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {
    @Autowired
    CandidatRepository candidatRepository;

    public Candidat findCandidatByprenomCandidatAndNomCandidat(String pre, String nom) {
        return candidatRepository.findCandidatByprenomCandidatAndNomCandidat(pre, nom);
    }

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
        if (candidat.getNomCandidat()==null){
            return null;
        }
        else if (candidat.getPrenomCandidat()==null){
            return null;
        }
        else {

            return candidatRepository.save(candidat);
        }
    }

    public List<Candidat> findCandidatByCampagneIdcampagne(long idf) {
        return candidatRepository.findCandidatByCampagneIdcampagne(idf);
    }
    public Candidat updateScore(Candidat cand, int ss,int m) {
        Candidat candUpl= findCandidatByIdcandidat(cand.getIdcandidat());
        int s= candUpl.getScore()+ss;
        candUpl.setScore(s);
        if (candUpl.getScore()>= m/2){
            candUpl.setReussiSelectionAuto(true);
        }
        return candidatRepository.save(candUpl);
    }
    public Candidat update(Candidat candidat) {
        Candidat candidatUpd= findCandidatByIdcandidat(candidat.getIdcandidat());
        candidatUpd.setNomCandidat(candidat.getNomCandidat());
        return candidatRepository.save(candidatUpd);
    }

    public List<Candidat> findCandidatByCampagneIdcampagneAndReussiSelectionAuto(long idf, Boolean a) {
        return candidatRepository.findCandidatByCampagneIdcampagneAndReussiSelectionAuto(idf, a);
    }

    public Candidat findCandidatByprenomCandidatAndNomCandidatAndCampagneIdcampagne(String pre, String nom, Long id) {
        return candidatRepository.findCandidatByprenomCandidatAndNomCandidatAndCampagneIdcampagne(pre, nom, id);
    }
}
