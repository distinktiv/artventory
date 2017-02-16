package com.artventory.distinktiv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by distinktiv on 2017-01-31.
 */
@Controller
@RequestMapping(value = "/album")
public class AlbumController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String admin_album_add(){

        return "admin/album.add";

    }
}
