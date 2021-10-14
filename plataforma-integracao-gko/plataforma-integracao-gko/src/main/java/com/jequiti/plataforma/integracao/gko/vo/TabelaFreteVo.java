package com.jequiti.plataforma.integracao.gko.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TabelaFreteVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2529907482293375773L;
	
	@JsonProperty("transportadora")
	private String transportadora;
	@JsonProperty("codigoTransportadora")
	private Long codigoTransportadora;
	@JsonProperty("tabela")
	private String nomeTabela;
	@JsonProperty("dataInicio")
	private Date dataInicio;
	@JsonProperty("dataFim")
	private Date dataFim;
	@JsonProperty("linhas")
	private List<LinhaTabelaFreteVo> linhas = new ArrayList<>();
	
	public TabelaFreteVo(String transportadora, Long codigoTransportadora, String nomeTabela, Date dataInicio,
			Date dataFim)
	{
		this.transportadora = transportadora;
		this.codigoTransportadora = codigoTransportadora;
		this.nomeTabela = nomeTabela;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public Long getCodigoTransportadora() {
		return codigoTransportadora;
	}

	public void setCodigoTransportadora(Long codigoTransportadora) {
		this.codigoTransportadora = codigoTransportadora;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

	public List<LinhaTabelaFreteVo> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaTabelaFreteVo> linhas) {
		this.linhas = linhas;
	}

	@Override
	public String toString() {
		return "TabelaFreteVo [transportadora=" + transportadora + ", codigoTransportadora=" + codigoTransportadora
				+ ", nomeTabela=" + nomeTabela + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", linhas="
				+ linhas + "]";
	}
}
