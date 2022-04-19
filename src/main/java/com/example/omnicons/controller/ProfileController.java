package com.example.omnicons.controller;

import com.example.omnicons.bean.Profile;
import com.example.omnicons.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/")
    public List<Profile> findAll() {
        return profileService.findAll();
    }
}
