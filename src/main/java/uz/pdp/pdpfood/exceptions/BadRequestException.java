package uz.pdp.pdpfood.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
