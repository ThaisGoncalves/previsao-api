package com.jequiti.plataforma.integracao.wms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.wms.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Optional<Pedido> findByCodigoPedido(Long codigoPedido);

}
