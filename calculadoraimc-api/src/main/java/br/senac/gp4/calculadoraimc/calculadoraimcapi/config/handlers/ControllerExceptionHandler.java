package br.senac.gp4.calculadoraimc.calculadoraimcapi.config.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseError handleValidationException(IllegalArgumentException e) {
        log.error(e.getMessage(),e);
        return new ResponseError(HttpStatus.BAD_REQUEST.value() , e.getMessage() , null );
    }

}
