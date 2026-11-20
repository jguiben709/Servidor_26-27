package com.daw.agrot.controllers;

import com.daw.agrot.services.ParcelaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    private final ParcelaService parcelaService;

    public InicioController(ParcelaService parcelaService) {
        this.parcelaService = parcelaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        //Recopilar información
        model.addAttribute("superficieTotal", parcelaService.superficieTotal());

        return "dashboard";
    }
}
