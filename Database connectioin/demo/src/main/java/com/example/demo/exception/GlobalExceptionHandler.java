package com.example.demo.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidation(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                 .getFieldError()
                 .getDefaultMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception e) {
        return "Error: " + e.getMessage();
    }
}