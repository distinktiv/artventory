package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.repository.PaintingRepository;
import com.artventory.distinktiv.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

    @RequestMapping(value = "/paintings/{userId}", method = RequestMethod.GET)
    public List<Painting> getAllPaintingFromUser(@PathVariable String userId){
        Long userIdLong = Long.parseLong(userId);
        return paintingService.getAllArtistPainting(userIdLong).orElse(Collections.EMPTY_LIST);
    }

    @RequestMapping(value = "/painting", method = RequestMethod.POST)
    public Painting createPainting(@RequestBody Painting form) {
        return paintingService.createPainting(form);
    }

    @RequestMapping(value = "/painting/edit/{id}", method = RequestMethod.GET)
    public Painting getPaintingById(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id);
        return paintingService.getPaintingFromId(idLong);
    }

}
