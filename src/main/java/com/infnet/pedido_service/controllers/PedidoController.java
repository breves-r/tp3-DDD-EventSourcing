package com.infnet.pedido_service.controllers;

import com.infnet.pedido_service.domain.Pedido;
import com.infnet.pedido_service.services.PedidoCommandService;
import com.infnet.pedido_service.services.PedidoQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
    private final PedidoCommandService commandService;
    private final PedidoQueryService queryService;

    public PedidoController(PedidoCommandService commandService, PedidoQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody Pedido pedido) {
        return commandService.criarPedido(pedido);
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable("id") String id) {
        return queryService.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido obterPorId(@PathVariable("id") String id) {
        return queryService.obterPorId(id).get();
    }
}
