package com.example.omnicons.Dao;


import com.example.omnicons.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByAuthority(String authority);
}
