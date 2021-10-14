package com.jequiti.atualiza.previsao.entrega.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jequiti.atualiza.previsao.entrega.client.JequitiClient;
import com.jequiti.atualiza.previsao.entrega.dto.AutenticacaoGkoDTO;
import com.jequiti.atualiza.previsao.entrega.dto.NotasFiscais;
import com.jequiti.atualiza.previsao.entrega.dto.Requisicao;
import com.jequiti.atualiza.previsao.entrega.service.AutenticacaoGkoService;
import com.jequiti.atualiza.previsao.entrega.service.ClienteGkoRestService;
import com.jequiti.atualiza.previsao.entrega.service.RequisicaoService;

@Service
public class ClienteGkoRestServiceImpl implements ClienteGkoRestService {
	private static final Logger logger = LoggerFactory.getLogger(ClienteGkoRestServiceImpl.class);

	@Autowired
	AutenticacaoGkoService autenticacaoGkoService;

	@Autowired
	RequisicaoService _requisicaoService;

	@Autowired
	JequitiClient _jequitiClient;

	@Override
	public NotasFiscais[] buscarFaturaGkoSemPPE() {

		NotasFiscais[] retorno = null;
		String buscarRequisicao = null;
		try {

			AutenticacaoGkoDTO autenticacao = this.autenticacaoGkoService.autenticaGko();

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(this._jequitiClient.getBuscarNotaFiscalSemDataEntrega() + autenticacao.getAccessToken());
			requisicao.setOperacao("SELECT");

			ObjectMapper mapper = new ObjectMapper();
			retorno = mapper.readValue(this._requisicaoService.requerer(requisicao).toString(), NotasFiscais[].class);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return retorno;
	}

	@Override
	public void atualizaNotasFiscaisSemPrevisaoEntrega(Map<String, String> value) {
		try {

			AutenticacaoGkoDTO autenticacao = this.autenticacaoGkoService.autenticaGko();

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(this._jequitiClient.getBuscarNotaFiscalSemDataEntrega() + autenticacao.getAccessToken());
			requisicao.setOperacao("UPDATE");
			requisicao.setObjeto(value);

			this._requisicaoService.requerer(requisicao);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
}
