package co.bancolombia.aplicacionbancaria.model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PrestamoDTO {
    private Long id;

    @NotNull(message = "El monto es obligatorio")
    @Min(value = 1, message = "El monto debe ser mayor a 0")
    private BigDecimal monto;

    @NotNull(message = "El interés es obligatorio")
    private BigDecimal interes;

    @Min(value = 1, message = "La duración debe ser de al menos 1 mes")
    private int duracionMeses;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    // Nuevo campo de ClienteDTO
    @NotNull(message = "El cliente es obligatorio")
    private ClienteDTO cliente;

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

    // Getter y setter para ClienteDTO
    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }
}
