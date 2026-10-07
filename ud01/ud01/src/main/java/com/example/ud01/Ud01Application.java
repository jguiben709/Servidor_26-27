package com.example.ud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Ud01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ud01Application.class, args);
    }

}
