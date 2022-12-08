package com.springmvc.restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan("com.springmvc.restapi")
public class Config {
    @Bean
    public RestTemplate restTemplate(){ //to make http requests
    return new RestTemplate();}
}
