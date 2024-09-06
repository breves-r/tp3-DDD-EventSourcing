package com.infnet.pedido_service.commands;

import java.util.List;

public class CriarPedidoCommand extends BaseCommand<String> {
    public final String clienteId;
    public final List<String> itens;

    public CriarPedidoCommand(String id, String clienteId, List<String> itens) {
        super(id);
        this.clienteId = clienteId;
        this.itens = itens;
    }
}
