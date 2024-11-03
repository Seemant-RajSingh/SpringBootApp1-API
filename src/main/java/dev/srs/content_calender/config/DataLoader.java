package dev.srs.content_calender.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello!");
    }
}




// older file - myWebConfig
//package dev.srs.content_calender.config;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class myWebConfig {
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplateBuilder().build();
//    }
//}