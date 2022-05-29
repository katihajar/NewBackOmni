package com.example.omnicons.services;

import com.example.omnicons.bean.Campagne;
import com.example.omnicons.Dao.CampagneRepository;
import com.example.omnicons.exception.NotAnImageFileException;
import com.example.omnicons.filter.JwtConstant;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.io.IOException;

import java.util.List;

@Service
public class CampagneService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    CampagneRepository campagneRepository ;


    public Campagne findCampagneByIdcampagne(long id) {
        return campagneRepository.findCampagneByIdcampagne(id);
    }
    public List<Campagne> findByCritere()
    {
        String query = "SELECT c FROM Campagne c order by c.idcampagne desc ";
        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }
    public List<Campagne> findAllWithOrder()
    {
        String query = "SELECT c FROM Campagne c order by c.idcampagne desc ";
        return entityManager.createQuery(query).getResultList();
    }
@Transactional
    public int deleteCampagneByIdcampagne(long id) {
        return campagneRepository.deleteCampagneByIdcampagne(id);
    }

    public List<Campagne> findAll() {
        return campagneRepository.findAll();
    }

    public Campagne save(Campagne campagne) throws IOException {
            return campagneRepository.save(campagne);

    }

    public Campagne updateSeuil(Campagne campagne,int ss) {
        Campagne campagneUpd= findCampagneByIdcampagne(campagne.getIdcampagne());
        int s= campagneUpd.getSeuil()+ss;
        campagneUpd.setSeuil(s);
        return campagneRepository.save(campagneUpd);
    }
    public Campagne update(Campagne campagne) {
        Campagne campagneUpd= findCampagneByIdcampagne(campagne.getIdcampagne());
        campagneUpd.setNomCampagne(campagne.getNomCampagne());
        campagneUpd.setDescription(campagne.getDescription());
        campagneUpd.setSeuil(campagne.getSeuil());
        return campagneRepository.save(campagneUpd);
    }


}
