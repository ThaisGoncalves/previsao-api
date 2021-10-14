package com.jequiti.plataforma.integracao.gko.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6208381239447432116L;
	
	@JsonProperty("logradouro")
	private String logradouro;
	@JsonProperty("bairro")
	private String bairro;
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("localidade")
	private String localidade;
	@JsonProperty("cep")
	private String cep;
	@JsonProperty("ibge")
	private Long ibge;
	
	public EnderecoVo(String logradouro, String bairro, String estado, String localidade, String cep, Long ibge) 
	{
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estado = estado;
		this.localidade = localidade;
		this.cep = cep;
		this.ibge = ibge;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getIbge() {
		return ibge;
	}

	public void setIbge(Long ibge) {
		this.ibge = ibge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EnderecoVo [logradouro=" + logradouro + ", bairro=" + bairro + ", estado=" + estado + ", localidade="
				+ localidade + ", cep=" + cep + ", ibge=" + ibge + "]";
	}
}
