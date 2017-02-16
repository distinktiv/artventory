package com.artventory.distinktiv.service.Exceptions;

/**
 * Created by distinktiv on 2017-01-07.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message){
        super(message);
    }

    public StorageException(String message, Throwable cause){
        super(message,cause);
    }

}
