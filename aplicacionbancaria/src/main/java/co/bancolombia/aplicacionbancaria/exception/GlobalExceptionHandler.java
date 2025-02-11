package co.bancolombia.aplicacionbancaria.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleClienteNoEncontradoException(ClienteNoEncontradoException ex) {
        Map<String, Object> response = new HashMap<>();
        //response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        //response.put("error", "Not Found");
        response.put("message", ex.getMessage());
        //response.put("path", "/api/clientes/{id}");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PrestamosNoEncontradosException.class)
    public ResponseEntity<Map<String, Object>> handlePrestamosNoEncontradosException(PrestamosNoEncontradosException ex) {
        Map<String, Object> response = new HashMap<>();
        //response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        //response.put("error", "Not Found");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidacionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleValidacionException(ValidacionException ex) {
        Map<String, Object> errorResponse = new LinkedHashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Error de validación");
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleJsonParseException(HttpMessageNotReadableException ex) {
        Map<String, Object> errorResponse = new LinkedHashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Error de formato JSON");

        String message = "El formato del JSON es inválido o faltan valores obligatorios.";
        Throwable cause = ex.getCause();

        if (cause instanceof JsonParseException) {
            message = "Ingrese los valores correctamente.";
        } else if (cause instanceof JsonMappingException) {
            message = "Error en la estructura del JSON o falta un campo obligatorio.";
        }

        errorResponse.put("message", message);
        return errorResponse;
    }
}