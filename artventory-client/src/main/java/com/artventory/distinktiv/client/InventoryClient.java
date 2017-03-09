package com.artventory.distinktiv.client;

import com.artventory.distinktiv.domain.Painting;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by distinktiv on 2017-02-18.
 */
@FeignClient(value = "inventory-service", serviceId = "inventory-service")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/paintings")
    Collection<Painting> getAllPaintingFromUser(@RequestParam("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/painting")
    Painting createUserPainting(@RequestBody Painting painting);
}
