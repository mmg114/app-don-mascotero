package com.mangoprograming.app.controller;

import com.mangoprograming.app.constants.Message;
import com.mangoprograming.app.controller.domain.ApiResponse;
import com.mangoprograming.app.model.Cliente;
import com.mangoprograming.app.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public ApiResponse<Cliente> getCliente(@RequestParam(name = "id") final String clienteId){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), clienteService.getCliente(clienteId));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/inventario/{id}")
    public ApiResponse<List<Cliente>> getAllCliente(@PathVariable(name = "id") final String inventarioId){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), clienteService.getAllCliente());
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ApiResponse<Cliente> saveCliente(@Valid @RequestBody final Cliente cliente){
        return ApiResponse.exitoso(Message.CREATED.getValor(), clienteService.save(cliente));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public ApiResponse<Cliente> updateCliente(@RequestBody final Cliente cliente){
        return ApiResponse.exitoso(Message.UPDATED.getValor(), clienteService.update(cliente));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping
    public ApiResponse<Cliente> deleteCliente(@NotBlank @RequestParam(name = "id")  final  String clienteId){
        return ApiResponse.exitoso(Message.DELETED.getValor(), clienteService.deleteById(clienteId));
    }



}
