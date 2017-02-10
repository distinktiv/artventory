package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by distinktiv on 2017-02-09.
 */
@Controller
@RequestMapping(value = "/hello")
public class UserController {

    @Autowired
    private UserClient userClient;


    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity getPage()
    {
        return new ResponseEntity(userClient.getAllUsers(), HttpStatus.OK);
    }
}
