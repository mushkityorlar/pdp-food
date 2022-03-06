package uz.pdp.pdpfood.exceptions;

import uz.pdp.pdpfood.response.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice("uz.pdp.pdpfood")
public class GlobalExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<AppError> handler(RuntimeException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new AppError(e.getMessage(),
                        webRequest,
                        HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
