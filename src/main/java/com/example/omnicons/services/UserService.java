package com.example.omnicons.services;

import com.example.omnicons.bean.User;
import com.example.omnicons.Dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserByIduser(Long id) {
        return userRepository.findUserByIduser(id);
    }

    public User findUserByEmailUser(String email) {
        return userRepository.findUserByEmailUser(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User createSalarie(User user) {
        return userRepository.save(user);
    }



    public Boolean deleteUser(Long idUser) {
        if(!userRepository.existsById(idUser)) return false;
        userRepository.deleteById(idUser);
        return true;
    }
}
