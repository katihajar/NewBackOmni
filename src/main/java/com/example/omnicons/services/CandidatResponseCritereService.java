package com.example.omnicons.services;

import com.example.omnicons.Dao.CandidatRepository;
import com.example.omnicons.Dao.CandidatResponseCritereDao;
import com.example.omnicons.bean.Candidat;
import com.example.omnicons.bean.CandidatResponseCritere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatResponseCritereService {
    @Autowired
    CandidatResponseCritereDao candidatResponseCritereDao;
    @Autowired
    CandidatService candidatService;

    public CandidatResponseCritere save(CandidatResponseCritere entity) {
        if(entity.getCritere().getValPositive().equals(entity.getResponse())) {
            candidatService.updateScore(entity.getCandidat(),entity.getCritere().getPoids(),entity.getCritere().getCampagne().getSeuil() );
        }
        return candidatResponseCritereDao.save(entity);
    }

    public List<CandidatResponseCritere> findByCandidatIdcandidatAndCampagneIdcampagne(Long id, long ids) {
        return candidatResponseCritereDao.findByCandidatIdcandidatAndCampagneIdcampagne(id, ids);
    }
}
