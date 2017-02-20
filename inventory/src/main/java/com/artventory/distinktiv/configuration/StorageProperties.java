package com.artventory.distinktiv.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by distinktiv on 2017-01-07.
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "src/main/resources/static/assets/upload-dir";

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {

        this.location = location;
    }
}
