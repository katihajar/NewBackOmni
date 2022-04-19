package com.example.omnicons.services;

import com.example.omnicons.bean.Campagne;
import com.example.omnicons.Dao.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampagneService {
    @Autowired
    CampagneRepository campagneRepository ;

    public Campagne findCampagneByIdcampagne(long id) {
        return campagneRepository.findCampagneByIdcampagne(id);
    }

    public List<Campagne> findAll() {
        return campagneRepository.findAll();
    }

    public Campagne save(Campagne campagne) {
            return campagneRepository.save(campagne);

    }
    public Campagne update(Campagne campagne) {
        Campagne campagneUpd= findCampagneByIdcampagne(campagne.getIdcampagne());
        campagneUpd.setNomCampagne(campagne.getNomCampagne());
        campagneUpd.setDescription(campagne.getDescription());
        campagneUpd.setSeuil(campagne.getSeuil());
        return campagneRepository.save(campagneUpd);
    }


}
