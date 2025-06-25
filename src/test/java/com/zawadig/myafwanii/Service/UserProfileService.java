package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.UserProfile;
import com.zawadig.myafwanii.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public Optional<UserProfile> getProfileByEmail(String email) {
        return repository.findById(Long.valueOf(email));
    }

    public UserProfile saveOrUpdateProfile(UserProfile profile) {
        return repository.save(profile);
    }
}

