package com.daw.demoinyeccion.controllers;

import com.daw.demoinyeccion.services.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("/cafe")
    public String cafe() { return cafeService.getAllCafes(); }

    @GetMapping("/cafe/{id}")
    public String cafe(@PathVariable Long id) {
        return cafeService.getCafeById(id);
    }

}
