package com.example.omnicons.controller;


import com.example.omnicons.bean.User;
import com.example.omnicons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping("/sign-in/{username}/{pass}")
    public ResponseEntity<User> signIn(@PathVariable String username,@PathVariable String pass) {
        return userService.signIn(username,pass);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }
    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
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


    @Transactional
    @DeleteMapping("/deleteUser/{id}")
    public int deleteUserByIduser(@PathVariable Long id) {
        return userService.deleteUserByIduser(id);
    }
}
