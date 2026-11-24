package com.daw.agrot.controllers;


import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoCultivo;
import com.daw.agrot.entities.TipoSensor;
import com.daw.agrot.services.ParcelaService;
import com.daw.agrot.services.SensorService;
import com.daw.agrot.services.TrabajadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parcels")
public class ParcelaController {

    private final ParcelaService parcelaService;
    private final TrabajadorService trabajadorService;

    public ParcelaController(ParcelaService parcelaService, TrabajadorService trabajadorService1) {
        this.parcelaService = parcelaService;
        this.trabajadorService = trabajadorService1;
    }

    @GetMapping
    public String getAllParcels(@RequestParam (required = false) String q,
                                @RequestParam(required = false) String tipo, Model model) {
        if (q == null) q = "";
        if (tipo == null) tipo = "TODOS";

        var parcelas = parcelaService.getAllParcelsByNameAndTipo(q, tipo);
        model.addAttribute("parcelas", parcelas);
        var tipos = TipoCultivo.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("q", q);
        model.addAttribute("tipo", tipo);
        return "parcelas/lista";
    }

    /**
     * Buscador desde Javascript por nombre de sensor. Devuelve un fragmento de la tabla de sensores.
     * @param q
     * @param model
     * @return
     */
    @GetMapping("/find")
    public String findAsinc(@RequestParam (required = false) String q, Model model) {

        if (q == null) q = "";
        var tipo = "TODOS";

        var parcels = parcelaService.getAllParcelsByNameAndTipo(q, tipo);
        model.addAttribute("parcelas", parcels);
        return "parcelas/lista :: tabla-parcelas";
    }

    @GetMapping("/{id}")
    public String getParcelaById(@PathVariable Long id, Model model) {
        var parcela = parcelaService.getParcelById(id);
        model.addAttribute("parcela", parcela);
        model.addAttribute("trabajadores", trabajadorService.getAllTrabajadores());
        //Sacar los trabajadores asignados a la parcela y pasarlos al modelo
        model.addAttribute("trabajadoresAsignados", parcela.getParcelasTrabajador());
        return "parcelas/detalle";
    }

    @GetMapping("/new")
    public String newParcela(Model model) {
        var tipos = TipoCultivo.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("parcela", new Parcela());
        return "parcelas/formulario";
    }

    @GetMapping("/update/{id}")
    public String updateParcela(@PathVariable Long id, Model model) {
        var parcela = parcelaService.getParcelById(id);
        var tipos = TipoCultivo.values();
        model.addAttribute("tipos", tipos);
        model.addAttribute("parcela", parcela);
        return "parcelas/formulario";
    }

    @PostMapping()
    public String saveParcela(@Valid Parcela parcela, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("tipos", TipoCultivo.values());
            return "parcelas/formulario";
        }

        parcelaService.saveParcel(parcela);
        return "redirect:/parcels";
    }

    @PostMapping("/delete/{id}")
    public String deleteParcela(@PathVariable Long id) {
        parcelaService.deleteParcelById(id);
        return "redirect:/parcels";
    }

    @PostMapping("/{id}/assignTrabajador")
    public String asignarTrabajador(@PathVariable Long id, @RequestParam Long trabajadorId, @RequestParam String fechaInicio) {
        parcelaService.asignarTrabajadorToParcela(id, trabajadorId, fechaInicio);
        return "redirect:/parcels/" + id;
    }


}
