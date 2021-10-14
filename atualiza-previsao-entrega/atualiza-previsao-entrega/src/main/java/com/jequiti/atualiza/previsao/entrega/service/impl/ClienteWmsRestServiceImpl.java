package com.jequiti.atualiza.previsao.entrega.service.impl;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jequiti.atualiza.previsao.entrega.client.JequitiClient;
import com.jequiti.atualiza.previsao.entrega.dto.AutenticacaoWmsDTO;
import com.jequiti.atualiza.previsao.entrega.dto.Requisicao;
import com.jequiti.atualiza.previsao.entrega.dto.wms.Fatura;
import com.jequiti.atualiza.previsao.entrega.dto.wms.Pedido;
import com.jequiti.atualiza.previsao.entrega.dto.wms.PedidoFatura;
import com.jequiti.atualiza.previsao.entrega.service.AutenticacaoWmsService;
import com.jequiti.atualiza.previsao.entrega.service.ClienteWmsRestService;
import com.jequiti.atualiza.previsao.entrega.service.RequisicaoService;

@Service
public class ClienteWmsRestServiceImpl implements ClienteWmsRestService {

	private static final Logger logger = LoggerFactory.getLogger(ClienteWmsRestServiceImpl.class);

	@Autowired
	AutenticacaoWmsService _autenticacaoWmsService;

	@Autowired
	RequisicaoService _requisicaoService;

	@Autowired
	JequitiClient _jequitiClient;

	@Override
	public Fatura findNotaWmsFatura(Long codigoTitulo) {

		AutenticacaoWmsDTO autenticacao = null;
		Fatura retorno = null;

		try {
			autenticacao = this._autenticacaoWmsService.autenticaWms();
		} catch (Exception ex) {
			logger.error("Erro na tentativa de obter a autenticação, {}", ex.getMessage());
		}

		try {

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(this._jequitiClient.getBuscarFaturaNumeroNotaFiscal() + autenticacao.getAccessToken());
			requisicao.setOperacao("SELECT");

			ObjectMapper mapper = new ObjectMapper();
			retorno = mapper.readValue(this._requisicaoService.requerer(requisicao), Fatura.class);

		} catch (Exception e) {
			logger.error("entrou na exception CRSI " + e);
		}

		return retorno;
	}

	@Override
	public Fatura findByNumeroNotaFiscal(String numeroNotaFiscal) {
		AutenticacaoWmsDTO autenticacao = null;
		Fatura retorno = null;

		try {
			autenticacao = this._autenticacaoWmsService.autenticaWms();
		} catch (Exception ex) {
			logger.error("Erro na tentativa de obter a autenticação, {}", ex.getMessage());
		}
		try {

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(this._jequitiClient.getUrlPostWms().replace("<numeroNotaFiscal>",
								numeroNotaFiscal)
					//"http://localhost:8008/api/faturaNumeroNotaFiscal/" + numeroNotaFiscal + "?access_token="
							+ autenticacao.getAccessToken());
			requisicao.setOperacao("SELECT");

			ObjectMapper mapper = new ObjectMapper();
			retorno = mapper.readValue(this._requisicaoService.requerer(requisicao), Fatura.class);

		} catch (Exception e) {
			logger.error("entrou na exception CRSI " + e);
		}

		return retorno;
	}

	@Override
	public PedidoFatura findByCodigoTitulo(Long codigoTitulo) {

		AutenticacaoWmsDTO autenticacao = null;
		PedidoFatura retorno = null;

		try {
			autenticacao = this._autenticacaoWmsService.autenticaWms();
		} catch (Exception ex) {
			logger.error("Erro na tentativa de obter a autenticação, {}", ex.getMessage());
		}
		try {

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(// this._jequitiClient.getUrlPostWms().replace("<numeroNotaFiscal>",
								// codigoTitulo)
					"http://localhost:8008/api/buscarCodigoTitulo/" + codigoTitulo + "?access_token="
							+ autenticacao.getAccessToken());
			requisicao.setOperacao("SELECT");

			ObjectMapper mapper = new ObjectMapper();
			retorno = mapper.readValue(this._requisicaoService.requerer(requisicao), PedidoFatura.class);

		} catch (Exception e) {
			logger.error("entrou na exception CRSI " + e);
		}

		return retorno;
	}

	@Override
	public Pedido findByCodigoPedido(Long codigoPedido) {

		AutenticacaoWmsDTO autenticacao = null;
		Pedido retorno = null;

		try {
			autenticacao = this._autenticacaoWmsService.autenticaWms();
		} catch (Exception ex) {
			logger.error("Erro na tentativa de obter a autenticação, {}", ex.getMessage());
		}
		try {

			Requisicao requisicao = new Requisicao();
			requisicao.setUrl(// this._jequitiClient.getUrlPostWms().replace("<numeroNotaFiscal>",
								// numeroNotaFiscal)
					"http://localhost:8008/api/pedido/" + codigoPedido + "?access_token="
							+ autenticacao.getAccessToken());
			requisicao.setOperacao("SELECT");

			ObjectMapper mapper = new ObjectMapper();
			retorno = mapper.readValue(this._requisicaoService.requerer(requisicao), Pedido.class);

		} catch (Exception e) {
			logger.error("entrou na exception CRSI " + e);
		}

		return retorno;
	}

}
