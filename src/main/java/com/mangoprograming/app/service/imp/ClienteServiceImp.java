package com.mangoprograming.app.service.imp;

import com.mangoprograming.app.exception.ClientException;
import com.mangoprograming.app.repository.ClienteRepository;
import com.mangoprograming.app.model.Cliente;
import com.mangoprograming.app.service.ClienteService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente save(  Cliente cliente) {


        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteExistente.isPresent()) {
            throw new ClientException("El cliente con este correo electrónico ya existe");
        }
        return  clienteRepository.save(cliente);
    }

    @Override
    public Cliente getCliente(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteExistente = this.getCliente(cliente.getId());
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefono(cliente.getTelefono());
            return clienteRepository.save(clienteExistente);
        }else
        {
            throw new ClientException("El cliente no existe");
        }
    }

    @Override
    public Cliente deleteById( final String id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClientException("No se encontró ningún cliente con el ID especificado: " + id));

        clienteRepository.deleteById(id);
       return new Cliente();
    }
}
