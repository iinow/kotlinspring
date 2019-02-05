package com.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;

@SpringBootApplication
public class BootGradleApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootGradleApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8072"));
        app.run(args);
    }
}
