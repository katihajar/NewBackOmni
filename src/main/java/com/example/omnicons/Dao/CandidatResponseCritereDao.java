package com.example.omnicons.Dao;

import com.example.omnicons.bean.CandidatResponseCritere;
import com.example.omnicons.bean.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatResponseCritereDao  extends JpaRepository<CandidatResponseCritere,Long> {
   public CandidatResponseCritere findCandidatResponseCritereByCandidatIdcandidat(Long id);
   public List<CandidatResponseCritere> findByCandidatIdcandidatAndCampagneIdcampagne(Long id,long ids);
}
