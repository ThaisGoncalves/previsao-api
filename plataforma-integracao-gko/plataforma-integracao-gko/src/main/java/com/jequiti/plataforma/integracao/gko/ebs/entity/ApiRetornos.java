package com.jequiti.plataforma.integracao.gko.ebs.entity;

import java.io.Serializable;

public class ApiRetornos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5249156439360197890L;
	
	private String statusCode;
	private String returnMessage;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
