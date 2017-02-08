package com.artventory.distinktiv.repository;

import com.artventory.distinktiv.domaine.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile findByName(String name);

}