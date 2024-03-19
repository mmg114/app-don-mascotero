package com.mangoprograming.app.controller;

import com.mangoprograming.app.constants.Message;
import com.mangoprograming.app.controller.domain.ApiResponse;
import com.mangoprograming.app.model.Pedido;
import com.mangoprograming.app.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public ApiResponse<Pedido> getPedido(@RequestParam(name = "id") final String pedidoId){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), pedidoService.getPedido(pedidoId));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/inventario/{id}")
    public ApiResponse<List<Pedido>> getAllPedido(@PathVariable(name = "id") final String inventarioId){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), pedidoService.getAllPedido());
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ApiResponse<Pedido> savePedido(@Valid @RequestBody final Pedido pedido){
        return ApiResponse.exitoso(Message.CREATED.getValor(), pedidoService.save(pedido));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public ApiResponse<Pedido> updatePedido(@RequestBody final Pedido pedido){
        return ApiResponse.exitoso(Message.UPDATED.getValor(), pedidoService.update(pedido));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping
    public ApiResponse<Pedido> deletePedido(@NotBlank @RequestParam(name = "id")  final  String pedidoId){
        return ApiResponse.exitoso(Message.DELETED.getValor(), pedidoService.deleteById(pedidoId));
    }



}
