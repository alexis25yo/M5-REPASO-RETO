package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.Prestamo;
import co.bancolombia.aplicacionbancaria.model.DTO.PrestamoDTO;
import org.springframework.stereotype.Component;

@Component
public class PrestamoMapper {

    public PrestamoDTO toDTO(Prestamo prestamo) {
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

    public Prestamo toEntity(PrestamoDTO dto) {
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
