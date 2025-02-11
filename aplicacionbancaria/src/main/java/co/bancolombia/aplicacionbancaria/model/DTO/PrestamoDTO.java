package co.bancolombia.aplicacionbancaria.model.DTO;

import java.math.BigDecimal;

public class PrestamoDTO {
    private Long id;
    private BigDecimal monto;
    private BigDecimal interes;
    private int duracionMeses;
    private String estado;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public BigDecimal getInteres() { return interes; }
    public void setInteres(BigDecimal interes) { this.interes = interes; }

    public int getDuracionMeses() { return duracionMeses; }
    public void setDuracionMeses(int duracionMeses) { this.duracionMeses = duracionMeses; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}