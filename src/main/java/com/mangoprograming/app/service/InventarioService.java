package com.mangoprograming.app.service;

import com.mangoprograming.app.model.Inventario;

import java.util.List;

public interface InventarioService {
    Inventario getInventario(String inventarioId);

    List<Inventario> getAllInventario();

    Inventario save(Inventario inventario);

    Inventario update(Inventario inventario);

    Inventario deleteById(String inventarioId);
}
