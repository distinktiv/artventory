package com.artventory.distinktiv.client;

import com.artventory.distinktiv.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by distinktiv on 2017-02-09.
 */
@FeignClient("users-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    Collection<User> getAllUsers();


}
