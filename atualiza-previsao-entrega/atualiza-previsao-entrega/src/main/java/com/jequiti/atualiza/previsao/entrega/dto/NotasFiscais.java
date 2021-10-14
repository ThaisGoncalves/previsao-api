package com.jequiti.atualiza.previsao.entrega.dto;

import lombok.Data;

@Data
public class NotasFiscais {
	private Long idNota;
	private Long idntaembarque;
	private String cdNota;
	private String cdSerie;
	private String dtEmissao;
	private String dsChaveAcesso;
	private String dtPrevisaoEntrega;	
}
