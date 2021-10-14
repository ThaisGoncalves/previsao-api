package com.jequiti.plataforma.integracao.wms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jequiti.plataforma.integracao.wms.entity.Fatura;
import com.jequiti.plataforma.integracao.wms.repository.FaturaRepository;

@Service
public class FaturaService {

	@Autowired
	private FaturaRepository repository;

	public Optional<Fatura> getFatura(Long codigoTitulo) {
		return repository.findById(codigoTitulo);

	}

	public Page<Fatura> listFatura(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		return repository.findAll(paging);
	}

	public Fatura findByCodigoTitulo(Long codigoTitulo) {
		return repository.findByCodigoTitulo(codigoTitulo);
	}
	
	public Fatura findByNumeroNotaFiscal(String numeroNotaFiscal){
		return repository.findByNumeroNotaFiscal(numeroNotaFiscal);
	}
	
}
