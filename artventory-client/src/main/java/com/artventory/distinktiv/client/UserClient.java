package com.artventory.distinktiv.client;

import com.artventory.distinktiv.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by distinktiv on 2017-02-09.
 */
@FeignClient(value = "users-service", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    Collection<User> getAllUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/users/email")
    User getUserByEmail(@RequestParam("email") String email);

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    User createUser(@RequestBody User user);

}
