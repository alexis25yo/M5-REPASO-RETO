package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.model.DTO.ClienteDTO;
import co.bancolombia.aplicacionbancaria.service.ClienteMapper;
import co.bancolombia.aplicacionbancaria.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getAllClientes();
    }
    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);  // Ya retorna un ClienteDTO desde el servicio
    }

    @PostMapping
    public ClienteDTO createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);  // Ahora el servicio maneja ClienteDTO
    }
}