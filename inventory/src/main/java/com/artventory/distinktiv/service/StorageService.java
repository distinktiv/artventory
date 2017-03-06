package com.artventory.distinktiv.service;

import org.springframework.core.io.Resource;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by distinktiv on 2017-01-03.
 */
public interface StorageService {
    void init();
    void store(File file);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();
}
