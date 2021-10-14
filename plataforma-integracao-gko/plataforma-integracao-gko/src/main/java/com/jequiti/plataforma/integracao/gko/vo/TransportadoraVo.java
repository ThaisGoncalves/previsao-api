package com.jequiti.plataforma.integracao.gko.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportadoraVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7802094023113848542L;
	
	@JsonProperty("id")
	private Long idTransportadora;
	@JsonProperty("codigo")
	private Long codigoTransportadora;
	@JsonProperty("razaoSocial")
	private String razaoSocial;
	@JsonProperty("fantasia")
	private String fantasia;
	@JsonProperty("nocgccpf")
	private String nocgccpf;
	@JsonProperty("inscricaoEstadual")
	private String inscricaoEstadual;
	@JsonProperty("inscricaoMunicipal")
	private String inscricaoMunicipal;
	@JsonProperty("enderecos")
	private List<EnderecoVo> enderecos = new ArrayList<>();	
	
	public TransportadoraVo(Long idTransportadora, Long codigoTransportadora, String razaoSocial, String fantasia,
			String nocgccpf, String inscricaoEstadual, String inscricaoMunicipal, List<EnderecoVo> enderecos) 
	{
		super();
		this.idTransportadora = idTransportadora;
		this.codigoTransportadora = codigoTransportadora;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.nocgccpf = nocgccpf;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.enderecos = enderecos;
	}

	public Long getIdTransportadora() {
		return idTransportadora;
	}

	public void setIdTransportadora(Long idTransportadora) {
		this.idTransportadora = idTransportadora;
	}

	public Long getCodigoTransportadora() {
		return codigoTransportadora;
	}

	public void setCodigoTransportadora(Long codigoTransportadora) {
		this.codigoTransportadora = codigoTransportadora;
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

	public List<EnderecoVo> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoVo> enderecos) {
		this.enderecos = enderecos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TransportadoraVo [idTransportadora=" + idTransportadora + ", codigoTransportadora="
				+ codigoTransportadora + ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia + ", nocgccpf="
				+ nocgccpf + ", inscricaoEstadual=" + inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", enderecos=" + enderecos + "]";
	}
}
