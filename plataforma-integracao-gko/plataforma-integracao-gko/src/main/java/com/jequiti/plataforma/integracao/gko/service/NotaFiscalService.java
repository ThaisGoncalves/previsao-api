package com.jequiti.plataforma.integracao.gko.service;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jequiti.plataforma.integracao.gko.entity.NotaFiscal;
import com.jequiti.plataforma.integracao.gko.repository.NotaFiscalRepository;


@Service
@Transactional
public class NotaFiscalService {
	private static Logger logger = LoggerFactory.getLogger(FreightPriceService.class);

	private final NotaFiscalRepository notaFiscalRepository;

	@Autowired
	public NotaFiscalService(NotaFiscalRepository notaFiscalRepository) {
		this.notaFiscalRepository = notaFiscalRepository;
	}

	@Transactional(readOnly = true)
	public List<NotaFiscal> obterNotasFiscaisSemPrevisaoEntegra() {
		logger.info("método de recuperação de notas fiscais sem data prevista de entrega");

		return notaFiscalRepository.getNotasSemPPE();
	}

	public NotaFiscal atualizaNotasFiscaisSemPrevisaoEntrega(Long idntaembarque, Date dtPrevisaoEntega) {
		logger.info("método de atualização de notas fiscais sem data prevista de entrega");

		return notaFiscalRepository.postNotasSemPPE(idntaembarque, dtPrevisaoEntega);
	}

}
