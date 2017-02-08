package com.artventory.distinktiv.service;

import com.artventory.distinktiv.domaine.Profile;

import java.util.Collection;

public interface ProfileService {
    Profile getProfileByName(String name);
    Collection<Profile> getAllProfile();
    Profile createProfile(Profile profile);

}
