package com.example.omnicons.Dao;

import com.example.omnicons.bean.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {
     Candidat findCandidatByIdcandidat(long idf);
    int deleteCandidatByIdcandidat(Long id);
}
