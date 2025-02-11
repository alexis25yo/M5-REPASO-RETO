package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.Prestamo;
import co.bancolombia.aplicacionbancaria.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/cliente/{clienteId}")
    public List<Prestamo> getPrestamosByClienteId(@PathVariable Long clienteId) {
        return prestamoService.getPrestamosByClienteId(clienteId);
    }

    @PostMapping
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.savePrestamo(prestamo);
    }
}