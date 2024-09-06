package com.infnet.pedido_service.services;

import com.infnet.pedido_service.domain.Pedido;
import com.infnet.pedido_service.infra.PedidoRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryService {
    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoQueryService(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Object> listarEventos(String id) {
        return eventStore.readEvents(id, 0)
                .asStream()
                .map(Message::getPayload).collect(Collectors.toList());
    }

    public Optional<Pedido> obterPorId(String id) {
        return pedidoRepository.findById(id);
    }
}