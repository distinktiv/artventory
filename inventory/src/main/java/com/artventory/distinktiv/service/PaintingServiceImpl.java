package com.artventory.distinktiv.service;


import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2016-12-29.
 */
@Service
public class PaintingServiceImpl implements PaintingService{

    private final PaintingRepository paintingRepository;

    @Autowired
    public PaintingServiceImpl(PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    @Override
    public Optional<List<Painting>> getAllPainting() {
        return Optional.of((List<Painting>) paintingRepository.findAllByOrderByIdDesc());
    }

    @Override
    public Optional<List<Painting>> getAllArtistPainting(Long id) {
        return Optional.of((List<Painting>) paintingRepository.findAllByArtistId(id));
    }


    @Override
    public Painting createPainting(Painting form) {
        Painting painting = new Painting();
        painting.setArtistId(form.getArtistId());
        painting.setTitle(form.getTitle());
        painting.setDescription(form.getDescription());
        painting.setCategory(form.getCategory());
        painting.setDimensionInch(form.getDimensionInch());
        painting.setDimensionCm(form.getDimensionCm());
        painting.setMedium(form.getMedium());
        painting.setTechnique(form.getTechnique());
        painting.setAvailability(form.getAvailability());
        painting.setPrice(form.getPrice());
        painting.setFile("Mon file name");

        return paintingRepository.save(painting);

    }

    @Override
    public Painting getPaintingFromId(Long id) {
        return paintingRepository.findById(id);
    }
}
