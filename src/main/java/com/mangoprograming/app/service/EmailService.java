package com.mangoprograming.app.service;

import com.mangoprograming.app.model.Cliente;
import com.mangoprograming.app.model.Pedido;
import jakarta.mail.MessagingException;

public interface EmailService {


    void sendMailPedido(Pedido pedido, Cliente cliente) ;
}
