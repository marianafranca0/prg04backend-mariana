package br.com.ifba.exception;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @Value(value="${server.error.include-exception}")
    private boolean printStackTrace;

   // @ExceptionHandler(MethodArgumentNotValidException.class)

}
