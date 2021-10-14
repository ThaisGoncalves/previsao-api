package com.jequiti.plataforma.integracao.wms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.wms.entity.PedidoFatura;

@Repository
public interface PedidoFaturaRepository extends JpaRepository<PedidoFatura, Long> {

	List<PedidoFatura> findByCodigoPedido(Long codigoPedido);

	Optional<PedidoFatura> findByCodigoTitulo(Long codigoTitulo);
}
