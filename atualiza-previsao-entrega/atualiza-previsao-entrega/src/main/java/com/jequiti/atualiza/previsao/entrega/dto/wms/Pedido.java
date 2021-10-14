package com.jequiti.atualiza.previsao.entrega.dto.wms;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pedido {


	private Long codigoPedido;
	
	private Long codigoPedidoPolo;
	
	private Long codigoSituacao;
	
	private LocalDate dataPrevisao;

}
