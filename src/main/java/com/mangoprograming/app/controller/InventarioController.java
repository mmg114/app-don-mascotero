package com.mangoprograming.app.controller;

import com.mangoprograming.app.constants.Message;
import com.mangoprograming.app.controller.domain.ApiResponse;
import com.mangoprograming.app.model.Inventario;
import com.mangoprograming.app.model.Inventario;
import com.mangoprograming.app.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/inventario" , produces = "application/json" , consumes = "application/json"  )
public class InventarioController {
    private final InventarioService inventarioService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/inventario/{id}")
    public ApiResponse<Inventario> getInventario(@PathVariable(name = "id") final String inventarioId){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), inventarioService.getInventario(inventarioId));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public ApiResponse<List<Inventario>> getAllInventario(){
        return ApiResponse.exitoso(Message.CONSULTED.getValor(), inventarioService.getAllInventario());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ApiResponse<Inventario> saveInventario(@Valid @RequestBody final Inventario inventario){
        return ApiResponse.exitoso(Message.CREATED.getValor(), inventarioService.save(inventario));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public ApiResponse<Inventario> updateInventario(@RequestBody final Inventario inventario){
        return ApiResponse.exitoso(Message.UPDATED.getValor(), inventarioService.update(inventario));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping
    public ApiResponse<Inventario> deleteInventario(@RequestParam(name = "id")  final  String inventarioId){
        return ApiResponse.exitoso(Message.DELETED.getValor(), inventarioService.deleteById(inventarioId));
    }
}
