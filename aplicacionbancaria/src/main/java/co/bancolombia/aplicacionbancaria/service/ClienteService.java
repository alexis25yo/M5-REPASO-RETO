package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.exception.ClienteNoEncontradoException;
import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}