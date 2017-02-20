package com.artventory.distinktiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2016-12-29.
 */
@Service
public class PaintingServiceImpl implements PaintingService{


    @Autowired
    public PaintingServiceImpl(PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    @Override
    public Optional<List<Painting>> getAllPainting() {
        return Optional.of((List<Painting>) paintingRepository.findAllByOrderByIdDesc());
    }

    @Override
    public Painting createPainting(PaintingCreatedForm form) {
        Painting painting = new Painting();
        painting.setTitle(form.getTitle());
        painting.setDescription(form.getDescription());
        painting.setCategory(form.getCategory());
        painting.setDimension(form.getDimension());
        painting.setMedium(form.getMedium());
        painting.setTechnique(form.getTechnique());
        painting.setAvailability(form.getAvailability());
        painting.setPrice(form.getPrice());
        painting.setFile(form.getFile().getOriginalFilename());

        return paintingRepository.save(painting);

    }
}
