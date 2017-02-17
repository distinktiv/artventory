package com.artventory.distinktiv;

import com.artventory.distinktiv.configuration.StorageProperties;
import com.artventory.distinktiv.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by distinktiv on 2017-02-15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(StorageProperties.class)
public class InventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args)->{
            //storageService.deleteAll();
            //storageService.init();
        };

    }

}
