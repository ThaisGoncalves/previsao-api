package com.jequiti.atualiza.previsao.entrega.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.jequiti.atualiza.previsao.entrega.dto.NotasFiscais;

public interface ClienteGkoRestService {

	public NotasFiscais[] buscarFaturaGkoSemPPE();	
	public void atualizaNotasFiscaisSemPrevisaoEntrega(Map<String, String> value);
	
}
