package com.jequiti.plataforma.integracao.wms.enums;

public enum MessageNotes {
	CEP_INVALIDO("O CEP informado não é valido."),
	ENDERECO_INVALIDO("Há divergência nas informações de endereço."),
	ENDERECO_OK("Endereço validado.");
	
	private String mensagem;
	
	private MessageNotes(String mensagem)
	{
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
