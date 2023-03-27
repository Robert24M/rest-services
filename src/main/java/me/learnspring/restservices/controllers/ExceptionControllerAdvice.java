package me.learnspring.restservices.controllers;

import me.learnspring.restservices.exceptions.NotEnoughMoneyException;
import me.learnspring.restservices.models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money.");

        return ResponseEntity
                .badRequest()
                .header("Exception Type", e.getClass().getName())
                .body(errorDetails);
    }
}
