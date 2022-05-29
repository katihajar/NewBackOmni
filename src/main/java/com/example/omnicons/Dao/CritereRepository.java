package com.example.omnicons.Dao;


import com.example.omnicons.bean.Critere;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CritereRepository extends JpaRepository<Critere,Long> {
    public Critere findCritereByIdcritere(Long id);
    int deleteCritereByIdcritere(Long id);

    List<Critere> findByCampagneIdcampagne(Long id);
}
