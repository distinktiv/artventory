package com.artventory.distinktiv.service;

import com.artventory.distinktiv.configuration.UserAccountSettings;
import com.artventory.distinktiv.domaine.User;
import com.artventory.distinktiv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ProfileService profileService;
    private final UserAccountSettings userAccountSettings;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProfileService profileService, UserAccountSettings userAccountSettings, UserAccountSettings userAccountSettings1) {
        this.userRepository = userRepository;
        this.profileService = profileService;
        this.userAccountSettings = userAccountSettings1;
    }
    @Override
    public Optional<Collection<User>> getAllUsers() {
        return Optional.of( (Collection<User>) userRepository.findAll());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}
