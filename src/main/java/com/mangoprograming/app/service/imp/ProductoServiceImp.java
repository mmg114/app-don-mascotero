package com.mangoprograming.app.service.imp;

import com.mangoprograming.app.exception.ClientException;
import com.mangoprograming.app.exception.ProductoException;
import com.mangoprograming.app.model.Producto;
import com.mangoprograming.app.model.Producto;
import com.mangoprograming.app.repository.ProductoRepository;
import com.mangoprograming.app.service.ProductoService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImp  implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {


        Optional<Producto> productoExistente = productoRepository.findByNombre(producto.getNombre());
        if (productoExistente.isPresent()) {
            throw new ProductoException("El producto con este nombre ya existe");
        }
        return  productoRepository.save(producto);
    }

    @Override
    public Producto getProducto(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto update(Producto producto) {
        Producto productoExistente = this.getProducto(producto.getId());
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setImagen(producto.getImagen());


            return productoRepository.save(productoExistente);
        }else
        {
            throw new ClientException("El producto no existe");
        }
    }

    @Override
    public Producto deleteById( final String id)  {
        productoRepository.findById(id)
                .orElseThrow(() -> new ClientException("No se encontró ningún producto con el ID especificado: " + id));

        productoRepository.deleteById(id);
        return new Producto();
    }
}