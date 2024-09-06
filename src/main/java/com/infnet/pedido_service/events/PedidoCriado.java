package com.infnet.pedido_service.events;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoCriado extends BaseEvent<String> {
    public final String clienteId;
    public final List<String> itens;

    public PedidoCriado(String id, String clienteId, List<String> itens) {
        super(id);
        this.clienteId = clienteId;
        this.itens = itens;
    }
}
