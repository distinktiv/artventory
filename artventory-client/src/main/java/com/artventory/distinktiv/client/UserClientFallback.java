package com.artventory.distinktiv.client;


import com.artventory.distinktiv.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Collection;

@Component
public class UserClientFallback implements UserClient{

    @Override
    public Collection<User> getAllUsers() {
        User user = new User();
        return Arrays.asList(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return new User();
    }

    @Override
    public User createUser(@RequestBody User user) {
        return null;
    }


}
