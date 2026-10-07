package com.example.demoservlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeController {

    @GetMapping("/cafe")
    public String cafe() {

        return "A esta hora necesito ya un café, me duermo";
    }


}
