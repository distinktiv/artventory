package com.artventory.distinktiv.service;

import com.artventory.distinktiv.domain.Painting;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2017-02-16.
 */
public interface InventoryService {

    List<Painting> getPaintingFromArtist(String id);
    Painting createPainting(File file, Painting form);
    Painting getPaintingById(String id);
}
