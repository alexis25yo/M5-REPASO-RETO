package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.DTO.SimulacionDTO;
import co.bancolombia.aplicacionbancaria.service.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulacion")
public class SimulacionController {

    @Autowired
    private SimulacionService simulacionCreditoService;

    @PostMapping
    public SimulacionDTO simularCredito(@RequestBody SimulacionDTO simulacion) {
        return simulacionCreditoService.calcularCuota(simulacion);
    }
}
