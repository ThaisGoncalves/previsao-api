package com.jequiti.atualiza.previsao.entrega.exception;

public class PrincipalException extends Exception {

	private static final long serialVersionUID = 758372394639574417L;
	private String msg;
	
	public PrincipalException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
