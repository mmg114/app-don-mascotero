package com.mangoprograming.app.controller.domain;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private boolean exitoso;
    private String mensaje;
    private T datos;

    public ApiResponse(boolean exitoso, String mensaje, T datos) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.datos = datos;
    }
    public static <T> ApiResponse<T> exitoso(String mensaje, T datos) {
        return new ApiResponse<>(true, mensaje, datos);
    }

    public static <T> ApiResponse<T> fallido(String mensaje) {
        return new ApiResponse<>(false, mensaje, null);
    }
}