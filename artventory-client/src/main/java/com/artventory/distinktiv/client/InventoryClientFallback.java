package com.artventory.distinktiv.client;

import com.artventory.distinktiv.domain.Painting;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by distinktiv on 2017-02-23.
 */
@Component
public class InventoryClientFallback implements InventoryClient {
    @Override
    public Collection<Painting> getAllPaintingFromUser(@RequestParam("id") Long id) {
        return null;
    }

    @Override
    public Painting createUserPainting(@RequestBody Painting painting) {
        return null;
    }
}