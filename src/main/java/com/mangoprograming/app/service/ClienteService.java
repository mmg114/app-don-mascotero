package com.mangoprograming.app.service;

import com.mangoprograming.app.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAllCliente();
    Cliente save(Cliente cliente);
    Cliente getCliente(String id);
    Cliente update(Cliente cliente);
    Cliente deleteById(final String id);

}
