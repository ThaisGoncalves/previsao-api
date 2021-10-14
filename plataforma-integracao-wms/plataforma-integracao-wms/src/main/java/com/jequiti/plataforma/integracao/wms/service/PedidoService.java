package com.jequiti.plataforma.integracao.wms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jequiti.plataforma.integracao.wms.entity.Pedido;
import com.jequiti.plataforma.integracao.wms.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repository;
	
	public Optional<Pedido> getPedido (Long codigoPedido){
		return repository.findById(codigoPedido);	
		
	} 
	
	public Optional<Pedido> findByCodigoPedido(Long codigoPedido) {
		return  repository.findByCodigoPedido(codigoPedido);
	}
	
	public Page<Pedido> listPedido(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		
		return repository.findAll(paging);
	}

}
