package com.example.omnicons.services;

import com.example.omnicons.bean.Profile;
import com.example.omnicons.Dao.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }
}
