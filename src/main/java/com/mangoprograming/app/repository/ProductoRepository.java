package com.mangoprograming.app.repository;

import com.mangoprograming.app.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {
    Optional<Producto> findByNombre(String nombre);


}
