package com.artventory.distinktiv.service;


import com.artventory.distinktiv.domain.Painting;

import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2016-12-29.
 */
public interface PaintingService {
    Optional<List<Painting>> getAllPainting();
    Optional<List<Painting>> getAllArtistPainting(Long id);
    Painting createPainting(Painting form);
    Painting getPaintingFromId(Long id);
}
