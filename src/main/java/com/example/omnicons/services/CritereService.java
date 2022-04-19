package com.example.omnicons.services;

import com.example.omnicons.bean.Critere;
import com.example.omnicons.Dao.CritereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return critereRepository.save(critere);
    }

    public void deleteById(Long id) {
        critereRepository.deleteById(id);
    }

    @Autowired
    CritereRepository critereRepository ;
}
