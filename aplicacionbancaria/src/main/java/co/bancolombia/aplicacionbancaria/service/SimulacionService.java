package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.exception.ValidacionException;
import co.bancolombia.aplicacionbancaria.model.DTO.SimulacionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SimulacionService {

    public SimulacionDTO calcularCuota(SimulacionDTO simulacion) {
        if (simulacion.getMonto() == null || simulacion.getInteresAnual() == null || simulacion.getDuracionMeses() <= 0) {
            throw new ValidacionException("Todos los campos (monto, interesAnual, duracionMeses) son obligatorios y deben ser válidos.");
        }

        BigDecimal monto = simulacion.getMonto();
        BigDecimal tasaAnual = simulacion.getInteresAnual();
        int meses = simulacion.getDuracionMeses();

        // Convertir la tasa de interés anual a mensual
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

        BigDecimal unoMasTasa = BigDecimal.ONE.add(tasaMensual).pow(meses);
        BigDecimal cuota = monto.multiply(tasaMensual).multiply(unoMasTasa)
                .divide(unoMasTasa.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

        simulacion.setCuotaMensual(cuota);
        return simulacion;
    }
}