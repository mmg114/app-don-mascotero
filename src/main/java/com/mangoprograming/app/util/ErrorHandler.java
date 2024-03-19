package com.mangoprograming.app.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ErrorHandler {
    public static String obtenerErrores(BindingResult bindingResult) {
        List<String> mensajesError = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return String.join("- ", mensajesError);

    }
}
