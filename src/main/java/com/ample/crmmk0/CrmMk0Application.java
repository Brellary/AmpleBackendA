package com.ample.crmmk0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmMk0Application {

    public static void main(String[] args) {

        SpringApplication.run(CrmMk0Application.class, args);
        System.out.println("Spring Boot server ready.Awaiting messages. ");
    }

}
