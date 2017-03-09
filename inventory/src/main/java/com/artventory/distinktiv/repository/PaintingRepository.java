package com.artventory.distinktiv.repository;


import com.artventory.distinktiv.domain.Painting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by distinktiv on 2016-12-29.
 */
public interface PaintingRepository extends CrudRepository<Painting,Long> {
    Painting findByTitle(String title);
    Painting findByFile(String file);
    List<Painting> findAllByArtistId(Long id);
    List<Painting> findAllByOrderByIdDesc();
}
