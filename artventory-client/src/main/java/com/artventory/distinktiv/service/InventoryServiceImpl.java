package com.artventory.distinktiv.service;


import com.artventory.distinktiv.client.InventoryClient;
import com.artventory.distinktiv.domain.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by distinktiv on 2016-12-29.
 */
@Service
public class InventoryServiceImpl implements InventoryService{


    private final InventoryClient inventoryClient;

    @Autowired
    public InventoryServiceImpl(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public Optional<List<Painting>> getPaintingFromArtist(Long id) {
        return Optional.of((List<Painting>) inventoryClient.getAllPaintingFromUser(id));
    }

    @Override
    public Painting createPainting(Painting form) {
        return inventoryClient.createUserPainting(form);
    }
}
