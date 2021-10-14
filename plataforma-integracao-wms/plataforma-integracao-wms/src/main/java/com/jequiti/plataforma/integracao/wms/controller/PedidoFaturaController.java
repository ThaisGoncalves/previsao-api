package com.jequiti.plataforma.integracao.wms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jequiti.plataforma.integracao.wms.entity.PedidoFatura;
import com.jequiti.plataforma.integracao.wms.service.PedidoFaturaService;

@RestController
public class PedidoFaturaController {

	@Autowired
	private PedidoFaturaService service;

	@RequestMapping(value = "/api/pedidoFatura/{codigoPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PedidoFatura>> getPedidoFatura(@PathVariable("codigoPedido") Long codigoPedido) {

		return new ResponseEntity<List<PedidoFatura>>(service.findByCodigoPedido(codigoPedido), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/api/buscarCodigoTitulo/{codigoTitulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<PedidoFatura>> getPedidoTitulo(@PathVariable("codigoTitulo") Long codigoTitulo) {

		return new ResponseEntity<Optional<PedidoFatura>>(service.buscarCodigoTitulo(codigoTitulo), HttpStatus.OK);

	}
}