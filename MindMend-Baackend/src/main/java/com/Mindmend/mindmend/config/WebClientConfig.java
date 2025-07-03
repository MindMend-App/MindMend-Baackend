package com.Mindmend.mindmend.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${ia.base-url}")
    private String iaBaseUrl;

    @Bean
    public WebClient iaWebClient() {
        return WebClient.builder()
                .baseUrl(iaBaseUrl)
                .build();
    }
}
