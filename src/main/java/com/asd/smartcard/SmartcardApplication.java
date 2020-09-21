package com.asd.smartcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SmartcardApplication {

    public static void main(String[] args) {
//        System.setProperty("server.servlet.context-path", "/index");

        SpringApplication.run(SmartcardApplication.class, args);

    }

}