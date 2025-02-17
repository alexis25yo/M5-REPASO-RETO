package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.Cliente;
import co.bancolombia.aplicacionbancaria.model.DTO.ClienteDTO;
import co.bancolombia.aplicacionbancaria.model.DTO.PrestamoDTO;
import co.bancolombia.aplicacionbancaria.model.Prestamo;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setPrestamos(toPrestamoDTOList(cliente.getPrestamos()));
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setPrestamos(toPrestamoList(dto.getPrestamos()));
        return cliente;
    }

    private List<PrestamoDTO> toPrestamoDTOList(List<Prestamo> prestamos) {
        if (prestamos == null) {
            return null;
        }
        return prestamos.stream().map(this::toPrestamoDTO).collect(Collectors.toList());
    }

    private PrestamoDTO toPrestamoDTO(Prestamo prestamo) {
        if (prestamo == null) {
            return null;
        }

        PrestamoDTO dto = new PrestamoDTO();
        dto.setId(prestamo.getId());
        dto.setMonto(prestamo.getMonto());
        dto.setInteres(prestamo.getInteres());
        dto.setDuracionMeses(prestamo.getDuracionMeses());
        dto.setEstado(prestamo.getEstado());
        return dto;
    }

    private List<Prestamo> toPrestamoList(List<PrestamoDTO> prestamoDTOs) {
        if (prestamoDTOs == null) {
            return null;
        }
        return prestamoDTOs.stream().map(this::toPrestamo).collect(Collectors.toList());
    }

    private Prestamo toPrestamo(PrestamoDTO dto) {
        if (dto == null) {
            return null;
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setId(dto.getId());
        prestamo.setMonto(dto.getMonto());
        prestamo.setInteres(dto.getInteres());
        prestamo.setDuracionMeses(dto.getDuracionMeses());
        prestamo.setEstado(dto.getEstado());
        return prestamo;
    }
}