package com.jequiti.plataforma.integracao.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jequiti.plataforma.integracao.wms.entity.Fatura;
import com.jequiti.plataforma.integracao.wms.service.FaturaService;

@RestController
public class FaturaController {

	@Autowired
	private FaturaService service;

	@RequestMapping(value = "/api/fatura/{codigoTitulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fatura> getFatura(@PathVariable("codigoTitulo") Long codigoTitulo) {

		return new ResponseEntity<Fatura>(service.getFatura(codigoTitulo).get(), HttpStatus.OK);

	}

	@RequestMapping(value = "/api/fatura", params = { "pageNo",
			"pageSize" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Fatura>> listFatura(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {

		return new ResponseEntity<Page<Fatura>>(service.listFatura(pageNo, pageSize), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/faturaNumeroNotaFiscal/codigoTitulo/{codigoTitulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fatura> getNumeroNotaFiscalByCodigoTitulo(@PathVariable("codigoTitulo") Long codigoTitulo) {

		return new ResponseEntity<Fatura>(service.findByCodigoTitulo(codigoTitulo), HttpStatus.OK);

	}

	@RequestMapping(value = "/api/faturaNumeroNotaFiscal/{numeroNotaFiscal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fatura> getNumeroNotaFiscal(@PathVariable("numeroNotaFiscal") String numeroNotaFiscal) {

		return new ResponseEntity<Fatura>(service.findByNumeroNotaFiscal(numeroNotaFiscal), HttpStatus.OK);

	}
}
