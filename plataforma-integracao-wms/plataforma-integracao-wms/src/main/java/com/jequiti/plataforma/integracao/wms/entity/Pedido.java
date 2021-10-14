package com.jequiti.plataforma.integracao.wms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {

	@Id
	@Column(name = "cod_pedido")
	private Long codigoPedido;
	@Column(name = "cod_pedido_polo")
	private Long codigoPedidoPolo;
	@Column(name = "cod_situacao")
	private Long codigoSituacao;
	@Column(name = "data_prevista_entrega")
	private LocalDate dataPrevisao;

}
