package com.artventory.distinktiv.service;


import com.artventory.distinktiv.client.InventoryClient;
import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.File;
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
    public Painting createPainting(File file, Painting form) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        form.setArtistId(user.getId());
        form.setPaintingFile(file);
        return inventoryClient.createUserPainting(form);
    }

}
