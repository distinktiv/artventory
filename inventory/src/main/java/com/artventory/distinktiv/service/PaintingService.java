package com.artventory.distinktiv.service;


import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.domain.form.PaintingCreatedForm;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2016-12-29.
 */
public interface PaintingService {
    Optional<List<Painting>> getAllPainting();
    Painting createPainting(File file, PaintingCreatedForm form);
}
