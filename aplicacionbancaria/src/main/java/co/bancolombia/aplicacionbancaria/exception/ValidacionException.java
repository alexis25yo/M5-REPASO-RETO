package co.bancolombia.aplicacionbancaria.exception;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}