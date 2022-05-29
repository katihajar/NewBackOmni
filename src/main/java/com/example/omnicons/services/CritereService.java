package com.example.omnicons.services;

import com.example.omnicons.bean.Candidat;
import com.example.omnicons.bean.Critere;
import com.example.omnicons.Dao.CritereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CritereService {
    public Critere findCritereByIdcritere(Long id) {
        return critereRepository.findCritereByIdcritere(id);
    }

    public List<Critere> findAll() {
        return critereRepository.findAll();
    }

    public  Critere save(Critere critere) {
        campagneService.updateSeuil(critere.getCampagne(),critere.getPoids());
        return critereRepository.save(critere);
    }

    public void deleteById(Long id) {
        critereRepository.deleteById(id);
    }

    public List<Critere> findByCampagneIdcampagne(Long id) {
        return critereRepository.findByCampagneIdcampagne(id);
    }
@Transactional
    public int deleteCritereByIdcritere(Long id) {
        return critereRepository.deleteCritereByIdcritere(id);
    }
    public Critere update(Critere cr) {
        Critere crr= findCritereByIdcritere(cr.getIdcritere());
        crr.setNomCritere(cr.getNomCritere());
        crr.setValPositive(cr.getValPositive());
        crr.setValNegative(cr.getValNegative());
        crr.setPoids(cr.getPoids());
        return critereRepository.save(crr);
    }
    @Autowired
    CritereRepository critereRepository ;
    @Autowired
    CampagneService campagneService ;
}
