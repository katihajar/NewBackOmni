package com.example.omnicons.Dao;


import com.example.omnicons.bean.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CritereRepository extends JpaRepository<Critere,Long> {
    public Critere findCritereByIdcritere(Long id);

}
