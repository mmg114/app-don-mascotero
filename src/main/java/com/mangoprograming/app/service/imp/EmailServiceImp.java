package com.mangoprograming.app.service.imp;

import com.mangoprograming.app.model.Cliente;
import com.mangoprograming.app.model.Pedido;
import com.mangoprograming.app.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class EmailServiceImp implements EmailService {

    private final TemplateEngine templateEngine;

    private final JavaMailSender  emailSender;

    private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Override
    @Async
    public void sendMailPedido(Pedido pedido, Cliente cliente)  {
        try {
        MimeMessage mensaje = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        helper.setTo(cliente.getEmail());
        helper.setSubject("Confirmación de Compra pedido " + pedido.getId());

        // Cargar y procesar la plantilla Thymeleaf
        String contenidoHtml = procesarPlantilla("email-compra-exitosa.html", pedido,cliente);

        helper.setText(contenidoHtml, true);
        emailSender.send(mensaje);

    } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, "Error al enviar el correo electrónico de confirmación de compra a " + cliente.getEmail(), e);
    }

    }

    private String procesarPlantilla(String nombrePlantilla, Pedido detallesCompra,Cliente cliente) {
        Context contexto = new Context();
        contexto.setVariable("nombreUsuario", cliente.getNombre());
        contexto.setVariable("productos", detallesCompra.getProductos());
        contexto.setVariable("totalCompra", detallesCompra.getTotal());
        return templateEngine.process(nombrePlantilla, contexto);
    }

}
