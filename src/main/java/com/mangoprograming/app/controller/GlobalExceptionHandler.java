package com.mangoprograming.app.controller;

import com.mangoprograming.app.controller.domain.ApiResponse;
import com.mangoprograming.app.exception.ClientException;
import com.mangoprograming.app.util.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.fallido(ErrorHandler.obtenerErrores(bindingResult)));
    }



    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ApiResponse> handleClienteException(ClientException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.fallido(ex.getMessage()));
    }
}
