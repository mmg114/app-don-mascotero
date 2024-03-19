package com.mangoprograming.app.service.imp;

import com.mangoprograming.app.exception.ClientException;
import com.mangoprograming.app.model.Pedido;
import com.mangoprograming.app.model.Pedido;
import com.mangoprograming.app.repository.PedidoRepository;
import com.mangoprograming.app.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImp implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {


        Optional<Pedido> pedidoExistente = pedidoRepository.findById(pedido.getId());
        if (pedidoExistente.isPresent()) {
            throw new ClientException("El pedido con este correo electrónico ya existe");
        }
        return  pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedido(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pedido> getAllPedido() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido update(Pedido pedido) {
        Pedido pedidoExistente = this.getPedido(pedido.getId());
        if (pedidoExistente != null) {
           pedidoExistente.setClienteId(pedido.getClienteId());
           pedidoExistente.setFecha(pedido.getFecha());
           pedidoExistente.setTotal(pedido.getTotal());
           pedidoExistente.setProductos(pedido.getProductos());
            return pedidoRepository.save(pedidoExistente);
        }else
        {
            throw new ClientException("El pedido no existe");
        }
    }

    @Override
    public Pedido deleteById( final String id) {
         pedidoRepository.findById(id)
                .orElseThrow(() -> new ClientException("No se encontró ningún pedido con el ID especificado: " + id));

        pedidoRepository.deleteById(id);
        return new Pedido();
    }
}
