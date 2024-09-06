package com.infnet.pedido_service.infra;

import com.infnet.pedido_service.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
