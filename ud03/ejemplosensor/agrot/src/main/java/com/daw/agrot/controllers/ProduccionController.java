package com.daw.agrot.controllers;

import com.daw.agrot.entities.Calidad;
import com.daw.agrot.entities.Produccion;
import com.daw.agrot.services.ParcelaService;
import com.daw.agrot.services.ProduccionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producciones")
public class ProduccionController {

    private final ProduccionService produccionService;
    private final ParcelaService parcelaService;

    public ProduccionController(ProduccionService produccionService,
                                ParcelaService parcelaService) {
        this.produccionService = produccionService;
        this.parcelaService = parcelaService;
    }

    @GetMapping
    public String getAllProducciones(Model model) {
        model.addAttribute("producciones", produccionService.getAllProducciones());
        return "producciones/lista";
    }

    @GetMapping("/{id}")
    public String getProduccionById(@PathVariable Long id, Model model) {
        model.addAttribute("produccion", produccionService.getProduccionById(id));
        return "producciones/detalle";
    }

    @GetMapping("/new")
    public String newProduccion(Model model) {
        model.addAttribute("produccion", new Produccion());
        model.addAttribute("calidades", Calidad.values());
        model.addAttribute("parcelas", parcelaService.getAllParcels());
        return "producciones/formulario";
    }

    @PostMapping
    public String saveProduccion(@Valid Produccion produccion,
                                 BindingResult errors,
                                 @RequestParam("parcelaId") Long parcelaId,
                                 Model model) {
        if (errors.hasErrors() || parcelaId == null) {
            model.addAttribute("calidades", Calidad.values());
            model.addAttribute("parcelas", parcelaService.getAllParcels());
            return "producciones/formulario";
        }

        //Mete la clave ajena de parcela en la producción antes de guardarla
        produccion.setParcela(parcelaService.getParcelById(parcelaId));
        //Guarda la producción en la base de datos
        produccionService.saveProduccion(produccion);
        return "redirect:/producciones";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduccion(@PathVariable Long id) {
        produccionService.deleteProduccionById(id);
        return "redirect:/producciones";
    }
}
