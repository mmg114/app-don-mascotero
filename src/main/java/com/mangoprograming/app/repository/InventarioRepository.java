package com.mangoprograming.app.repository;

import com.mangoprograming.app.model.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventarioRepository extends MongoRepository<Inventario,String> {
}
