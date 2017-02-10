package com.artventory.distinktiv.config;

import com.artventory.distinktiv.client.UserClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(clients = UserClient.class)
@Configuration
public class FeignConfig {
}
