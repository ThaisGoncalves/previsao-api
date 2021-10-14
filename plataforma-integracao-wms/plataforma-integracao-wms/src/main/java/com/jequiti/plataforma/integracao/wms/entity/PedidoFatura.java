package com.jequiti.plataforma.integracao.wms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pedido_titulo")
@Data
public class PedidoFatura {

	@Id
	@Column(name = "cod_pedido")
	private Long codigoPedido;
	@Column(name = "cod_titulo")
	private Long codigoTitulo;

}
