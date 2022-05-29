package com.example.omnicons.Dao;

import com.example.omnicons.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmailUser(String email);
    User findUserByIduser(Long id);
    User findByUsername(String username);
    int deleteUserByIduser(Long id);
    User findByUsernameAndPassword(String username,String pass);

}
