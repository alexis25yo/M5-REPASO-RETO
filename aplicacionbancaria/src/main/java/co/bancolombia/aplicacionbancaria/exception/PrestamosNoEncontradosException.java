package co.bancolombia.aplicacionbancaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PrestamosNoEncontradosException extends RuntimeException {
    public PrestamosNoEncontradosException(Long clienteId) {
        super("No se encontraron préstamos para el cliente con ID " + clienteId);
    }
}