package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.repository.PaintingRepository;
import com.artventory.distinktiv.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * Created by distinktiv on 2016-12-27.
 */

@RestController
public class PaintingController {
    private static final Logger LOG = Logger.getLogger(PaintingController.class.getName());
    @Autowired
    private PaintingService paintingService;

    @Autowired
    private PaintingRepository paintingRepository;

    @RequestMapping(value = "/paintings", method = RequestMethod.GET)
    public Collection<Painting> getAllPainting(){
        return paintingService.getAllPainting().orElse(Collections.EMPTY_LIST);
    }

    @RequestMapping(value = "/painting", method = RequestMethod.POST)
    public Painting createPainting(@RequestBody Painting form) {
        return paintingService.createPainting(form);
    }

}
