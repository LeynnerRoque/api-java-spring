package br.com.alura.curso.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity exception404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity exceptionNull(){
        return ResponseEntity.ofNullable("Register not exist");
    }
}
