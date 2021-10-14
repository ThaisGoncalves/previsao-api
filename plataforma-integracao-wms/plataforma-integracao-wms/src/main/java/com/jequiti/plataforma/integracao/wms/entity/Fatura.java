package com.jequiti.plataforma.integracao.wms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "titulo")
@Data
public class Fatura {

	@Id
	@Column(name = "cod_titulo")
	private Long codigoTitulo;
	@Column(name = "numero_titulo")
	private String numeroNotaFiscal;
	@Column(name = "serie_nf")
	private String serieNotaFiscal;
	@Column(name = "chave_acesso")
	private String chaveAcesso;

}
