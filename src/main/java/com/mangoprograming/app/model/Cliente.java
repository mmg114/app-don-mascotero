package com.mangoprograming.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Email(message = "Email no es valido", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "El Email es obligatorio")
    private String email;
    @NotBlank(message = "El Telefono es obligatorio")
    private String telefono;
    @NotBlank(message = "El Direccion es obligatorio")
    private String direccion;
}
