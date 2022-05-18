package pl.zapas.web.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String handleIndex(IndexOutOfBoundsException e) {
        return "This is out of bound exception" + e.getMessage();
    }
}
