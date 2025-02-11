package co.bancolombia.aplicacionbancaria.model.DTO;

import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private List<PrestamoDTO> prestamos; // No incluimos el objeto Cliente dentro de PrestamoDTO

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<PrestamoDTO> getPrestamos() { return prestamos; }
    public void setPrestamos(List<PrestamoDTO> prestamos) { this.prestamos = prestamos; }
}
