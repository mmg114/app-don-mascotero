package com.mangoprograming.app.service;

import com.mangoprograming.app.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto getProducto(String productoId);

    List<Producto> getAllProducto();

    Producto save(Producto producto);

    Producto update(Producto producto);

    Producto deleteById(final String  id);
}
