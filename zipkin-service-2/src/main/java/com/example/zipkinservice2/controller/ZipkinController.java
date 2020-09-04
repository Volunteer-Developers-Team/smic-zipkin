package com.example.zipkinservice2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RequiredArgsConstructor
@RestController
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

    @GetMapping(value = "/zipkin2")
    public String zipkinService1() throws InterruptedException {
        log.info("Inside zipkinService 2..");
        log.info("Now let's create some intentional delay...");
        Thread.sleep(20000);
        log.info("returning after delay..");

        return restTemplate.exchange("http://localhost:8083/zipkin3",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }).getBody();
    }
}
