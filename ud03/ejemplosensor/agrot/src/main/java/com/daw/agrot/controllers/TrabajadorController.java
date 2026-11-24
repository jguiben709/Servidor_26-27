package com.daw.agrot.controllers;

import com.daw.agrot.entities.Trabajador;
import com.daw.agrot.services.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public String getAllTrabajadores(Model model) {
        model.addAttribute("trabajadores", trabajadorService.getAllTrabajadores());
        return "trabajadores/lista";
    }

    @GetMapping("/{id}")
    public String getTrabajadorById(@PathVariable Long id, Model model) {
        model.addAttribute("trabajador", trabajadorService.getTrabajadorById(id));
        return "trabajadores/detalle";
    }

    @GetMapping("/new")
    public String newTrabajador(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "trabajadores/formulario";
    }

    @PostMapping
    public String saveTrabajador(Trabajador trabajador) {
        trabajadorService.saveTrabajador(trabajador);
        return "redirect:/trabajadores";
    }

    @PostMapping("/delete/{id}")
    public String deleteTrabajador(@PathVariable Long id) {
        trabajadorService.deleteTrabajadorById(id);
        return "redirect:/trabajadores";
    }








}
