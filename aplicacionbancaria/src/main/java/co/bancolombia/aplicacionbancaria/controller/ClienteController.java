package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.model.DTO.ClienteDTO;
import co.bancolombia.aplicacionbancaria.service.ClienteMapper;
import co.bancolombia.aplicacionbancaria.service.ClienteService;
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
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return clienteMapper.toDTO(cliente);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }
}