package com.artventory.distinktiv.client;

import com.artventory.distinktiv.domain.Painting;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by distinktiv on 2017-02-18.
 */
@FeignClient(value = "inventory-service", serviceId = "inventory-service")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/paintings/{userId}")
    List<Painting> getAllPaintingFromUser(@PathVariable("userId") String userId);

    @RequestMapping(method = RequestMethod.POST, value = "/painting")
    Painting createUserPainting(@RequestBody Painting painting);

    @RequestMapping(method = RequestMethod.GET, value = "/painting/edit/{id}")
    Painting getPaintingById(@PathVariable("id") String id);
}
