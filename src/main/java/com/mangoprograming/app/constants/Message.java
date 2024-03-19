package com.mangoprograming.app.constants;

public enum Message   {
    APPROVED("Approved"),
    CREATED("Created"),
    CONSULTED("Consulted"),
    DELETED("Deleted"),
    UPDATED("Updated");
    private final String valor;

    Message(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}