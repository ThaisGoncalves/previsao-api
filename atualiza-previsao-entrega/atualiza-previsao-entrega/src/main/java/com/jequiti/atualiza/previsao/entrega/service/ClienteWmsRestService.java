package com.jequiti.atualiza.previsao.entrega.service;

import com.jequiti.atualiza.previsao.entrega.dto.wms.Fatura;
import com.jequiti.atualiza.previsao.entrega.dto.wms.Pedido;
import com.jequiti.atualiza.previsao.entrega.dto.wms.PedidoFatura;

public interface ClienteWmsRestService {

	Fatura findNotaWmsFatura(Long codigoTitulo);

	Fatura findByNumeroNotaFiscal(String numeroNotaFiscal);

	PedidoFatura findByCodigoTitulo(Long codigoTitulo);

	Pedido findByCodigoPedido(Long codigoPedido);

}
