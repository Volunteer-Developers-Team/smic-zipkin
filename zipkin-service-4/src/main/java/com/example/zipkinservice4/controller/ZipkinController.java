package com.example.zipkinservice4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ZipkinController {

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/zipkin4")
    public String zipkinService1() {
        log.info("Inside zipkinService 4..");
        return "Hi...";
    }
}
