package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.exception.ClienteNoEncontradoException;
import co.bancolombia.aplicacionbancaria.exception.PrestamosNoEncontradosException;
import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.model.Prestamo;
import co.bancolombia.aplicacionbancaria.repository.ClienteRepository;
import co.bancolombia.aplicacionbancaria.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Prestamo> getPrestamosByClienteId(Long clienteId) {
        List<Prestamo> prestamos = prestamoRepository.findByClienteIdOrderByFechaCreacionDesc(clienteId);

        if (prestamos.isEmpty()) {
            throw new PrestamosNoEncontradosException(clienteId);
        }

        return prestamos;
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        Long clienteId = prestamo.getCliente().getId();

        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isEmpty()) {
            throw new ClienteNoEncontradoException(clienteId);
        }

        return prestamoRepository.save(prestamo);
    }
}