package com.xq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildApplication.class, args);
    }

}
