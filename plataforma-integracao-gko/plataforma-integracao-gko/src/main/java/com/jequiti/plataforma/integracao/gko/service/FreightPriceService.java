package com.jequiti.plataforma.integracao.gko.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jequiti.plataforma.integracao.gko.entity.Ocorrencia;
import com.jequiti.plataforma.integracao.gko.entity.TabelaFrete;
import com.jequiti.plataforma.integracao.gko.entity.Transportadora;
import com.jequiti.plataforma.integracao.gko.repository.FreightPriceRepository;

@Service
@Transactional
public class FreightPriceService {
	private static Logger logger = LoggerFactory.getLogger(FreightPriceService.class);
	
	private final FreightPriceRepository repository;
	
	@Autowired
	public FreightPriceService(FreightPriceRepository repository)
	{
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<TabelaFrete> getFreightPriceTable(Long codigoTransportadora, String localidade) 
	{
		List<TabelaFrete> tabela = new ArrayList<>();

		logger.info("Buscando tabela de peço de frete para a Transportadora: {}", codigoTransportadora);
		logger.info("Lócalidade informada: {}", localidade);

		tabela = repository.getFreightPriceTable(codigoTransportadora, localidade);

		return tabela;
	}
	
	@Transactional(readOnly = true)
	public List<Transportadora> getCarrier(String cnpj)
	{
		List<Transportadora> transportadoras =  null;
		
		logger.info("Buscando dados da Transportadora (CNPJ): {}",cnpj);
		
		transportadoras =  repository.getCarrier(cnpj);
		
		return transportadoras;
	}
	
	@Transactional(readOnly = true)
	public List<Ocorrencia> getOccurrences(String codigoPedido) {
		
		logger.info("Buscando ocorrências para o pedido: {}", codigoPedido);
		
		return repository.getOccurrences(codigoPedido);
	}

}
