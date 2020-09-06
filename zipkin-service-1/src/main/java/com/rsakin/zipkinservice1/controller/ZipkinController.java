package com.rsakin.zipkinservice1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ZipkinController {

    private final RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    @GetMapping(value = "/zipkin")
    public String zipkinService1() {
        log.info("Inside zipkinService 1..");

        String response = restTemplate.exchange("http://localhost:8082/zipkin2",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }).getBody();

        log.info("Zipkin2 restTEmplate response : {}", response);

        return "Hi...";
    }
}


