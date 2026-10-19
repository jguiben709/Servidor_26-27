package com.daw.agrot.controllers;


import com.daw.agrot.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public String getAllSensors(Model model) {
        //Obtener los sensores
        var sensors = sensorService.getAllSensors();

        //Pasárselos a la vista
        model.addAttribute("sensors", sensors);

        return "sensors";
    }


}
