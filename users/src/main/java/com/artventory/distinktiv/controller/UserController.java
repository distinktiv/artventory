package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domaine.User;
import com.artventory.distinktiv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<User> getAllUsers(){
        return userService.getAllUsers().orElse(Collections.EMPTY_LIST);
    }

    @RequestMapping(method = RequestMethod.GET, value="/email")
    User getUserByEmail(@RequestParam("email") String email){
        return userService.getUserByEmail(email).orElse(new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    //Create, Update, Delete

}
