package com.artventory.distinktiv.service;

import com.distinktiv.service.Exceptions.StorageException;
import com.distinktiv.service.Exceptions.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by distinktiv on 2017-01-07.
 */
@Service
public class StorageServiceImpl implements StorageService {
    private final Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }


    @Override
    public void init() {

        try {
            if(!Files.isDirectory(rootLocation)){
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new StorageException("Can't initialize file storage");
        }
    }

    @Override
    public void store(MultipartFile file) {
        if(file.isEmpty()){
            throw new StorageException("Can't store empty file " + file.getOriginalFilename());
        }
        try {
            Files.copy(file.getInputStream(),this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(),e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootLocation,1)
                    .filter(path -> !path.equals(rootLocation))
                    .map(path -> rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Could not load stored files", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        Path file = load(filename);
        try{

            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new StorageFileNotFoundException("Cannot read resource" + filename);
            }
        }catch(MalformedURLException e){
            throw new StorageFileNotFoundException("Could not load and read file" + filename);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
