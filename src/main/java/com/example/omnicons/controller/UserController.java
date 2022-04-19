package com.example.omnicons.controller;


import com.example.omnicons.bean.User;
import com.example.omnicons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/Getuser/{id}")
    public User findUserByIdUser(@PathVariable Long id) {
        return userService.findUserByIduser(id);
    }

    @GetMapping("/User/{email}")
    public User findUserByEmailUser(@PathVariable String email) {
        return userService.findUserByEmailUser(email);
    }
    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PostMapping("/")
    public User createSalarie(@RequestBody User user) {
        return userService.createSalarie(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable Long idUser) {
        return userService.deleteUser(idUser);
    }
}
