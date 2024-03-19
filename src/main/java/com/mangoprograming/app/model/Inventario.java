package com.mangoprograming.app.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "inventario")
public class Inventario {
    @Id
    private String id;
    private String productoId;
    private int cantidad;
    private LocalDateTime fechaActualizacion;
}