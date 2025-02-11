package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByClienteIdOrderByFechaCreacionDesc(Long clienteId);
}