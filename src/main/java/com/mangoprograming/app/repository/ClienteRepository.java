package com.mangoprograming.app.repository;

import com.mangoprograming.app.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
     Optional<Cliente> findByEmail(String email);
}
