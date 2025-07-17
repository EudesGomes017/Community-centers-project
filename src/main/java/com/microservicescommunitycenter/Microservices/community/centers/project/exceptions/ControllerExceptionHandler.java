package com.microservicescommunitycenter.Microservices.community.centers.project.exceptions;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.customErros.CustomError;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.exceotionsServices.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> fieldErrors = e.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        err -> err.getField(),
                        err -> err.getDefaultMessage(),
                        (first, second) -> first // em caso de campos repetidos
                ));

        CustomError err = new CustomError(
                Instant.now(),
                status.value(),
                "Erro de validação nos campos",
                request.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity.status(status).body(err);
    }
}
