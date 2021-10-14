package com.jequiti.atualiza.previsao.entrega.dto;

import lombok.Data;

@Data
public class AutenticacaoWms {

	private String authToken;
    private Long issuedAt;
    private String endPoint;
}
