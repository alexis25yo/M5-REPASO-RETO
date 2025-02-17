package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.DTO.PrestamoDTO;
import co.bancolombia.aplicacionbancaria.model.Prestamo;
import co.bancolombia.aplicacionbancaria.service.PrestamoMapper;
import co.bancolombia.aplicacionbancaria.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private PrestamoMapper prestamoMapper;

    @GetMapping("/cliente/{clienteId}")
    public List<PrestamoDTO> getPrestamosByClienteId(@PathVariable Long clienteId) {
        List<Prestamo> prestamos = prestamoService.getUltimos3PrestamosByClienteId(clienteId);
        return prestamos.stream().map(prestamoMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public PrestamoDTO createPrestamo(@Valid @RequestBody PrestamoDTO prestamoDTO) {
        Prestamo prestamo = prestamoMapper.toEntity(prestamoDTO);
        Prestamo savedPrestamo = prestamoService.savePrestamo(prestamoDTO);
        return prestamoMapper.toDTO(savedPrestamo);
    }
}