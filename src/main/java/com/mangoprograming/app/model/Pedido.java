package com.mangoprograming.app.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String id;
    private String clienteId;
    private List<ItemPedido> productos;
    private double total;
    private LocalDateTime fecha;

    // Constructor, getters y setters
}