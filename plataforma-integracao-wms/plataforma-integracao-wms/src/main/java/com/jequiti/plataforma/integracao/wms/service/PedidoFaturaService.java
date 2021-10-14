package com.jequiti.plataforma.integracao.wms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jequiti.plataforma.integracao.wms.entity.PedidoFatura;
import com.jequiti.plataforma.integracao.wms.repository.PedidoFaturaRepository;

@Service
public class PedidoFaturaService {
	@Autowired
	private PedidoFaturaRepository repository;

	public Optional<PedidoFatura> getPedidoFatura(Long codigoPedido) {
		return repository.findById(codigoPedido);

	}

	public List<PedidoFatura> findByCodigoPedido(Long codigoPedido) {
		return repository.findByCodigoPedido(codigoPedido);
	}

	public Optional<PedidoFatura> buscarCodigoTitulo(Long codigoTitulo) {
		return repository.findByCodigoTitulo(codigoTitulo);
	}
}