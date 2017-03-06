package com.artventory.distinktiv.service;

import com.artventory.distinktiv.domain.Painting;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2017-02-16.
 */
public interface InventoryService {

    Optional<List<Painting>> getPaintingFromArtist(Long id);
    Painting createPainting(File file, Painting form);
}
