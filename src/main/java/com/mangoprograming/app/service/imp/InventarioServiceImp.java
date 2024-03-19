package com.mangoprograming.app.service.imp;

import com.mangoprograming.app.exception.ClientException;
import com.mangoprograming.app.exception.InventarioException;
import com.mangoprograming.app.model.Inventario;
import com.mangoprograming.app.repository.InventarioRepository;

import com.mangoprograming.app.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventarioServiceImp implements InventarioService {

    private final InventarioRepository inventarioRepository;

    @Override
    public Inventario save(Inventario inventario) {


        Optional<Inventario> inventarioExistente = inventarioRepository.findById(inventario.getId());
        if (inventarioExistente.isPresent()) {
            throw new InventarioException("El inventario con este nombre ya existe");
        }
        return  inventarioRepository.save(inventario);
    }

    @Override
    public Inventario getInventario(String id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario update(Inventario inventario) {
        Inventario inventarioExistente = this.getInventario(inventario.getId());
        if (inventarioExistente != null) {
          inventarioExistente.setProductoId(inventario.getProductoId());
          inventarioExistente.setCantidad(inventario.getCantidad());
            inventarioExistente.setFechaActualizacion(inventario.getFechaActualizacion());

            return inventarioRepository.save(inventarioExistente);
        }else
        {
            throw new ClientException("El inventario no existe");
        }
    }

    @Override
    public Inventario deleteById( final String id)  {
        inventarioRepository.findById(id)
                .orElseThrow(() -> new ClientException("No se encontró ningún inventario con el ID especificado: " + id));

        inventarioRepository.deleteById(id);
        return new Inventario();
    }
}