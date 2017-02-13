package com.artventory.distinktiv.service;

import com.artventory.distinktiv.domaine.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);
    Optional<Collection<User>> getAllUsers();
    User createUser(User user);
}
