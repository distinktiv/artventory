package com.artventory.distinktiv.config;

import com.artventory.distinktiv.client.UserClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(clients = UserClient.class)
public class FeignConfig {
}
