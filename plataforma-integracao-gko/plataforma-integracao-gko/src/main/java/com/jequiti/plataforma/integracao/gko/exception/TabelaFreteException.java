package com.jequiti.plataforma.integracao.gko.exception;

import java.io.Serializable;

public class TabelaFreteException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3316163971163326345L;
	
	private String mensagem;

	public TabelaFreteException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMensagem() {
		return mensagem;
	}	
	

}
