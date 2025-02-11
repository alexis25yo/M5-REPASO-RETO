package co.bancolombia.aplicacionbancaria.model.DTO;

import java.math.BigDecimal;

public class SimulacionDTO {
    private BigDecimal monto;
    private BigDecimal interesAnual;
    private int duracionMeses;
    private BigDecimal cuotaMensual;

    // Getters y Setters
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public BigDecimal getInteresAnual() { return interesAnual; }
    public void setInteresAnual(BigDecimal interesAnual) { this.interesAnual = interesAnual; }

    public int getDuracionMeses() { return duracionMeses; }
    public void setDuracionMeses(int duracionMeses) { this.duracionMeses = duracionMeses; }

    public BigDecimal getCuotaMensual() { return cuotaMensual; }
    public void setCuotaMensual(BigDecimal cuotaMensual) { this.cuotaMensual = cuotaMensual; }
}