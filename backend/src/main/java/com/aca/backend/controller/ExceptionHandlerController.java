package com.aca.backend.controller;

import com.aca.backend.model.ExceptionResponse;
import com.aca.backend.model.ObservationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ObservationException.class)
    public ResponseEntity<ExceptionResponse> handleObservationException(
            ObservationException observationException, HttpServletRequest request) {

        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(observationException.getMessage());
        response.setRequestURI(request.getRequestURI());

        return ResponseEntity.badRequest().body(response);
    }
}
