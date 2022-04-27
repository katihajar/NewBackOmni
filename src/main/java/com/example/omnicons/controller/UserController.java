package com.example.omnicons.controller;


import com.example.omnicons.bean.User;
import com.example.omnicons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    @PostMapping("/sign-in/")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        return userService.signIn(user);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }


    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/Getuser/{id}")
    public User findUserByIdUser(@PathVariable Long id) {
        return userService.findUserByIduser(id);
    }

    @GetMapping("/User/{email}")
    public User findUserByEmailUser(@PathVariable String email) {
        return userService.findUserByEmailUser(email);
    }
    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable Long idUser) {
        return userService.deleteUser(idUser);
    }
}
