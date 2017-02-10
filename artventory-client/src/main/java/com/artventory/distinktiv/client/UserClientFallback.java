package com.artventory.distinktiv.client;


import com.artventory.distinktiv.domain.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class UserClientFallback implements UserClient{

    @Override
    public Collection<User> getAllUsers() {
        User user = new User();
        user.setFirstName("toto");
        return Arrays.asList(user);
    }
}
