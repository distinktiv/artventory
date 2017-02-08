package com.artventory.distinktiv.repository;

import com.artventory.distinktiv.domaine.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}