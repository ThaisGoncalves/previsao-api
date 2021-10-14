package com.jequiti.plataforma.integracao.gko.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jequiti.plataforma.integracao.gko.entity.TabelaFrete;
import com.jequiti.plataforma.integracao.gko.entity.Transportadora;
import com.jequiti.plataforma.integracao.gko.service.FreightPriceService;
import com.jequiti.plataforma.integracao.gko.vo.EnderecoVo;
import com.jequiti.plataforma.integracao.gko.vo.LinhaTabelaFreteVo;
import com.jequiti.plataforma.integracao.gko.vo.TabelaFreteVo;
import com.jequiti.plataforma.integracao.gko.vo.TransportadoraVo;

@RestController
public class FreightPriceRestController {
	private static final Logger logger = LoggerFactory.getLogger(FreightPriceRestController.class);
	
	private final FreightPriceService service;

	@Autowired
	public FreightPriceRestController(FreightPriceService service) 
	{
		this.service = service;
	}
	
	
	@RequestMapping(value = "/api/frete/tabela/transportadora/{codigoTransportadora}", method = RequestMethod.GET)
	public ResponseEntity<Object> findFreightPriceTable(@PathVariable Long codigoTransportadora)
	{
		List<TabelaFrete> tabela = new ArrayList<>();
		
		logger.info("Entrou na API de requisição de tabela de preço do frete por Transportadora");
		
		try {
			tabela = service.getFreightPriceTable(codigoTransportadora, null);
		} catch (Exception ex) {
			logger.error("Falha / erro na tentativa de recuperar os dados da tabela de preço do frete, {}",
					ex.getMessage());

			return new ResponseEntity<Object>(
					"Falha / erro na tentativa de recuperar os dados da tabela de preço do frete " + "\n"
							+ ex.getMessage(),
					new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		int indx = 0;
		TabelaFreteVo tabelaVo = null;
		LinhaTabelaFreteVo linhaVo;
		List<LinhaTabelaFreteVo> linhasVo = new ArrayList<>();
		
		try{
			for (TabelaFrete tabelaFrete : tabela) 
			{
				if (indx == 0) 
				{
					tabelaVo = new TabelaFreteVo(tabelaFrete.getRazaoSocial(), tabelaFrete.getCodTransportadora(),
							tabelaFrete.getNmTabela(), tabelaFrete.getDataInicial(), tabelaFrete.getDataFinal());
				}
				
				linhaVo = new LinhaTabelaFreteVo(tabelaFrete.getCodZonaTransporte(), tabelaFrete.getNoTrpTarifa(),
						tabelaFrete.getVlrTaxa().movePointRight(2), tabelaFrete.getMeioTransporte(), tabelaFrete.getLocalidade(),
						tabelaFrete.getEstado(), tabelaFrete.getIbge(), tabelaFrete.getCepInicio(), tabelaFrete.getCepFim(),
						tabelaFrete.getPesoInicio().movePointRight(2), tabelaFrete.getPesoFim().movePointRight(2), tabelaFrete.getValor().movePointRight(2),
						tabelaFrete.getPrazo(), tabelaFrete.getGris().movePointRight(2), tabelaFrete.getAdValorem().movePointRight(2));
				
				linhasVo.add(linhaVo);
	
			}		
			tabelaVo.setLinhas(linhasVo);
		}
		catch(Exception ex){
			logger.error("Falha / erro na montagem do JSON da tabela de preço do frete,{}", ex.getMessage());
			
			return new ResponseEntity<Object>("Falha / erro na montagem do JSON da tabela de preço do frete " + "\n" + ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		return new ResponseEntity<Object>(tabelaVo, new HttpHeaders(), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/api/frete/transportadora/{cnpj}", method = RequestMethod.GET)
	public ResponseEntity<Object> findCarrier(@PathVariable String cnpj) 
	{
		List<EnderecoVo> enderecos = new ArrayList<>();
		List<Transportadora> transportadoras = null;

		logger.info("Entrou na API de recuperação de dados do Transportador");

		try {
			transportadoras = service.getCarrier(cnpj);
		} catch (Exception ex) {
			logger.error("Falha / erro na tentativa de recuperar os dados da transportadora, {}", ex.getMessage());

			return new ResponseEntity<Object>(
					"Falha / erro na tentativa de recuperar os dados da transportadora " + "\n" + ex.getMessage(),
					new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		EnderecoVo enderecoVo = null;
		TransportadoraVo transportadoraVo = null;
		try {
			for (Transportadora transportadora : transportadoras) 
			{
				enderecoVo = new EnderecoVo(transportadora.getLogradouro(), transportadora.getBairro(),
						transportadora.getEstado(), transportadora.getLocalidade(), transportadora.getNocep(), null);

				enderecos.add(enderecoVo);

				transportadoraVo = new TransportadoraVo(transportadora.getIdTransportadora(),
						transportadora.getCdTransportadora(), transportadora.getRazaoSocial(),
						transportadora.getFantasia(), transportadora.getNocgccpf(),
						transportadora.getInscricaoEstadual(), transportadora.getInscricaoMunicipal(), enderecos);
			}
		} catch (Exception ex) {
			logger.error("Falha / erro na montagem do JSON da transportadora,{}", ex.getMessage());
			
			return new ResponseEntity<Object>("Falha / erro na montagem do JSON da transportadora " + "\n" + ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Object>(transportadoraVo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/frete/ocorrencia/pedido/{codigoPedido}", method = RequestMethod.GET)
	public ResponseEntity<Object> findOccurrencesByOrderCode(@PathVariable String codigoPedido) throws IOException {

		logger.info("Entrou na API de recuperação de ocorrências por pedido");

		String ocorrenciasJson = null;
		try {
			ocorrenciasJson = new ObjectMapper().writeValueAsString(service.getOccurrences(codigoPedido));
		} catch (Exception ex) {
			logger.error("Falha / erro na montagem do JSON da ocorrência,{}", ex.getMessage());

			return new ResponseEntity<Object>(
					"Falha / erro na montagem do JSON da ocorrência " + "\n" + ex.getMessage(), new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Object>(new ObjectMapper().readTree(ocorrenciasJson), new HttpHeaders(), HttpStatus.OK);
	}

}
