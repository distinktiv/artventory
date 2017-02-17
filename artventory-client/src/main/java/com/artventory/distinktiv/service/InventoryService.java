package com.artventory.distinktiv.service;

import com.artventory.distinktiv.domain.Painting;

import java.util.Collection;

/**
 * Created by distinktiv on 2017-02-16.
 */
public interface InventoryService {

    Collection<Painting> getPaintingFromArtist(String email);
}
