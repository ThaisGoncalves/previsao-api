package com.jequiti.atualiza.previsao.entrega.dto.wms;

import lombok.Data;

@Data
public class Pageable {

	private Sort sort;
	private int offset;
	private int pageSize;
	private int pageNumber;
	private Boolean paged;
	private Boolean unpaged;
}
