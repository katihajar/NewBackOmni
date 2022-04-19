package com.example.omnicons.Dao;


import com.example.omnicons.bean.Campagne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagneRepository extends JpaRepository<Campagne,Long> {


     Campagne findCampagneByIdcampagne(long id);

}
