package com.infnet.pedido_service.services;

import com.infnet.pedido_service.commands.CriarPedidoCommand;
import com.infnet.pedido_service.domain.Pedido;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {
    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getClienteId(),
                pedido.getItens()
        ));
    }
}
