package com.jequiti.plataforma.integracao.wms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jequiti.plataforma.integracao.wms.entity.Pedido;
import com.jequiti.plataforma.integracao.wms.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/api/pedido/{codigoPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Pedido>> getPedido(@PathVariable("codigoPedido") Long codigoPedido) {

		return new ResponseEntity<Optional<Pedido>>(service.findByCodigoPedido(codigoPedido), HttpStatus.OK);

	}

	@RequestMapping(value = "/api/pedido", params = { "pageNo", "pageSize" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Pedido>> listPedido(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {

		return new ResponseEntity<Page<Pedido>>(service.listPedido(pageNo, pageSize), HttpStatus.OK);
	}

}
