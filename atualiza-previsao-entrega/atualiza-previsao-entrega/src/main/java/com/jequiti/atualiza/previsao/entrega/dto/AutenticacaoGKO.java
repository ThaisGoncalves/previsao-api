package com.jequiti.atualiza.previsao.entrega.dto;

import lombok.Data;

@Data
public class AutenticacaoGKO {
	
	private String authToken;
    private Long issuedAt;
    private String endPoint;
}
