package com.example.demoservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemoServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServletApplication.class, args);
    }

}
