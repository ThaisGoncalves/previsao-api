package com.jequiti.plataforma.integracao.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.wms.entity.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

	Fatura findByCodigoTitulo(Long codigoTitulo);
	Fatura findByNumeroNotaFiscal(String numeroNotaFiscal);
}
