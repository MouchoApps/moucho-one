package com.mouchoapps.mouchoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.mouchoapps.mouchoone"})
public class BackendHelloWorldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendHelloWorldServiceApplication.class, args);
    }

}
