package com.jequiti.atualiza.previsao.entrega.dto;


import lombok.Data;

@Data
public class Requisicao {

	private String url;
	private String token;
	private Object objeto;
	private String operacao;
}
