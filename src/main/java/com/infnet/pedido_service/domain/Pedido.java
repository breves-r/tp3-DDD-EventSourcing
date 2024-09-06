package com.infnet.pedido_service.domain;

import com.infnet.pedido_service.commands.CriarPedidoCommand;
import com.infnet.pedido_service.events.PedidoCriado;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

@Aggregate
@Entity
public class Pedido {
    @AggregateIdentifier
    @Id
    private String id;
    private String clienteId;
    private List<String> itens;
    private String status;

    public Pedido() {
    }

    @CommandHandler
    public Pedido(CriarPedidoCommand comando) {
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.clienteId, comando.itens));
    }

    @EventSourcingHandler
    public void on(PedidoCriado evento) {
        this.id = evento.id;
        this.clienteId = evento.clienteId;
        this.itens = evento.itens;
        this.status = String.valueOf(Status.CRIADO);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
