package com.jequiti.atualiza.previsao.entrega.dto.wms;

import lombok.Data;

@Data
public class Fatura {

	private Long codigoTitulo;

	private String numeroNotaFiscal;
	
	private String serieNotaFiscal;

	private String chaveAcesso;

}
