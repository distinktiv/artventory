package com.artventory.distinktiv.service.Exceptions;

/**
 * Created by distinktiv on 2017-01-07.
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message){
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
