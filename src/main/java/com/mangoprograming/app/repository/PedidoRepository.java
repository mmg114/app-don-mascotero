package com.mangoprograming.app.repository;

import com.mangoprograming.app.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido,String> {
}
