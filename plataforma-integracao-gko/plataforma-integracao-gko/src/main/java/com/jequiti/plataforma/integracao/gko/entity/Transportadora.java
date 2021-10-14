package com.jequiti.plataforma.integracao.gko.entity;

import java.io.Serializable;

public class Transportadora implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826558208971393317L;
	
	private Long idTransportadora;
	private Long cdTransportadora;
	private String razaoSocial;
	private String fantasia;
	private String nocgccpf;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String logradouro;
	private String bairro;
	private String nocep;
	private String localidade;
	private String estado;
	
	public Long getIdTransportadora() {
		return idTransportadora;
	}
	public void setIdTransportadora(Long idTransportadora) {
		this.idTransportadora = idTransportadora;
	}
	public Long getCdTransportadora() {
		return cdTransportadora;
	}
	public void setCdTransportadora(Long cdTransportadora) {
		this.cdTransportadora = cdTransportadora;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getNocgccpf() {
		return nocgccpf;
	}
	public void setNocgccpf(String nocgccpf) {
		this.nocgccpf = nocgccpf;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
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
	
	public String getNocep() {
		return nocep;
	}
	public void setNocep(String nocep) {
		this.nocep = nocep;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Transportadora [idTransportadora=" + idTransportadora + ", cdTransportadora=" + cdTransportadora
				+ ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia + ", nocgccpf=" + nocgccpf
				+ ", inscricaoEstadual=" + inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", logradouro=" + logradouro + ", bairro=" + bairro + ", cep=" + nocep + ", localidade=" + localidade
				+ ", estado=" + estado + "]";
	}
}
