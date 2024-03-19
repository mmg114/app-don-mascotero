package com.mangoprograming.app.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private Long stock;
    private Byte[] imagen;
}
