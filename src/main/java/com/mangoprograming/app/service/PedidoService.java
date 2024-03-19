package com.mangoprograming.app.service;

import com.mangoprograming.app.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> getAllPedido();
    Pedido save(Pedido pedido);
    Pedido getPedido(String id);
    Pedido update(Pedido pedido);
    Pedido deleteById(String id);

}
