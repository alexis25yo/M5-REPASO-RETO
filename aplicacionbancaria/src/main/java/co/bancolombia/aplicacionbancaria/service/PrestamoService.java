package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.exception.ClienteNoEncontradoException;
import co.bancolombia.aplicacionbancaria.exception.PrestamosNoEncontradosException;
import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.model.DTO.PrestamoDTO;
import co.bancolombia.aplicacionbancaria.model.Prestamo;
import co.bancolombia.aplicacionbancaria.repository.ClienteRepository;
import co.bancolombia.aplicacionbancaria.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;  // Usamos el ClienteMapper

    public Prestamo savePrestamo(PrestamoDTO prestamoDTO) {
        if (prestamoDTO.getCliente() == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo en el DTO.");
        }

        Cliente cliente = clienteMapper.toEntity(prestamoDTO.getCliente());

        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
        if (clienteExistente.isEmpty()) {
            throw new ClienteNoEncontradoException(cliente.getId());
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setCliente(cliente);
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setInteres(prestamoDTO.getInteres());
        prestamo.setDuracionMeses(prestamoDTO.getDuracionMeses());
        prestamo.setEstado(prestamoDTO.getEstado());

        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> getUltimos3PrestamosByClienteId(Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isEmpty()) {
            throw new ClienteNoEncontradoException(clienteId);
        }

        Pageable topThree = PageRequest.of(0, 3);
        Page<Prestamo> prestamosPage = prestamoRepository.findByClienteIdOrderByFechaCreacionDesc(clienteId, topThree);

        if (prestamosPage.isEmpty()) {
            throw new PrestamosNoEncontradosException(clienteId);
        }

        return prestamosPage.getContent();
    }



}
