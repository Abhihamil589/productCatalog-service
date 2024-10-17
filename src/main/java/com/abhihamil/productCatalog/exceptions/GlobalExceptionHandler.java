package com.abhihamil.productCatalog.exceptions;

import com.abhihamil.productCatalog.dtos.ErrorDataDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDataDTO> productNotFoundHandler(NotFoundException notFoundException) {
        return new ResponseEntity<>(new ErrorDataDTO(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
