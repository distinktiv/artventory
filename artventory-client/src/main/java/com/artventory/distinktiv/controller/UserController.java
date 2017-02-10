package com.artventory.distinktiv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by distinktiv on 2017-02-09.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String getPage(){
        return("Hello CLient");
    }
}
