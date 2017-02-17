package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by distinktiv on 2016-12-27.
 */

@RestController
@RequestMapping(value = "/paintings")
public class PaintingController {

    @Autowired
    private PaintingService paintingService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Painting> getAllPainting(){
        return paintingService.getAllPainting().orElse(Collections.EMPTY_LIST);
    }



}
