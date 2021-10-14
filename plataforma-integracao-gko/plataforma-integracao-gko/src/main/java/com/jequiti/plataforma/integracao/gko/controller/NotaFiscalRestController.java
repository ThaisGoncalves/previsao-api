package com.jequiti.plataforma.integracao.gko.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jequiti.plataforma.integracao.gko.service.NotaFiscalService;

@RestController
public class NotaFiscalRestController {
	private static final Logger logger = LoggerFactory.getLogger(NotaFiscalRestController.class);

	private final NotaFiscalService notaFiscalService;

	@Autowired
	public NotaFiscalRestController(NotaFiscalService notaFiscalService) {
		this.notaFiscalService = notaFiscalService;
	}

	@RequestMapping(value = "/api/nota-fiscal/embarque/sem-data-entega", method = RequestMethod.GET)
	public ResponseEntity<Object> buscaNotasFiscaisSemPrevisaoEntrega() throws IOException {

		logger.info("Entrou na API de recuperação de notas fiscais sem previsão de entrega");

		String notasFiscaisJson = null;
		try {
			notasFiscaisJson = new ObjectMapper()
					.writeValueAsString(notaFiscalService.obterNotasFiscaisSemPrevisaoEntegra());
		} catch (Exception ex) {
			logger.error("Falha / erro na montagem do JSON de notas fiscais sem PPE,{}", ex.getMessage());

			return new ResponseEntity<Object>(
					"Falha / erro na montagem do JSON de notas fiscais sem PPE" + "\n" + ex.getMessage(),
					new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Object>(new ObjectMapper().readTree(notasFiscaisJson), new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/api/nota-fiscal/embarque/atualiza-sem-data-entega", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> atualizaNotasFiscaisSemPrevisaoEntrega(@RequestBody Map<String, String> value)

			throws IOException, ParseException {

		Long idEmbarque = Long.valueOf(value.get("idNtaEmbarque"));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataPrevistaEntrega = format.parse(value.get("dtPrevisaoEntrega"));

		logger.info("Entrou na API de atualizacao de notas fiscais sem previsão de entrega");

		return new ResponseEntity<Object>(
				notaFiscalService.atualizaNotasFiscaisSemPrevisaoEntrega(idEmbarque, dataPrevistaEntrega),
				new HttpHeaders(), HttpStatus.OK);
	}

}
