package com.example.omnicons.Dao;

import com.example.omnicons.bean.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {
     Candidat findCandidatByIdcandidat(long idf);
     Candidat findCandidatByprenomCandidatAndNomCandidat(String pre,String nom);
     Candidat findCandidatByprenomCandidatAndNomCandidatAndCampagneIdcampagne(String pre,String nom,Long id);
     List<Candidat> findCandidatByCampagneIdcampagne(long idf);
     List<Candidat> findCandidatByCampagneIdcampagneAndReussiSelectionAuto(long idf, Boolean a);
    int deleteCandidatByIdcandidat(Long id);
}
