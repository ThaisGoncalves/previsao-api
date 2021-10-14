package com.jequiti.plataforma.integracao.wms.enums;

public enum ApiStatusCode {
	E_STS_UNEXP_ERROR("U"),
	E_STS_ERROR("E"),
	E_STS_SUCCESS("S");
	
	private String statusCode;
	
	private ApiStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	
	public String getStatusCode()	
	{
		return statusCode;
	}

}
