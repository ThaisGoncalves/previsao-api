package com.jequiti.plataforma.integracao.gko.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinhaTabelaFreteVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1585095556301850761L;
	
	@JsonProperty("codigoZonaTransporte")
	private String zonaTransporte;
	@JsonProperty("noTrpTarifa")
	private String noTarifa;
	@JsonProperty("valorTaxa")
	private BigDecimal valorTaxa;
	@JsonProperty("meioTransporte")
	private String meioTransaporte;
	@JsonProperty("localidade")
	private String localidade;
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("ibge")
	private Long ibge;
	@JsonProperty("cepInicio")
	private String cepInicio;
	@JsonProperty("cepFim")
	private String cepFim;
	@JsonProperty("pesoInicio")
	private BigDecimal pesoInicio;
	@JsonProperty("pesoFim")
	private BigDecimal pesoFim;
	@JsonProperty("preco")
	private BigDecimal preco;
	@JsonProperty("prazo")
	private Integer prazo;
	@JsonProperty("gris")
	private BigDecimal gris;
	@JsonProperty("adValorem")
	private BigDecimal adValorem;
	
	public LinhaTabelaFreteVo(String zonaTransporte, String noTarifa, BigDecimal valorTaxa, String meioTransaporte,
			String localidade, String estado, Long ibge, String cepInicio, String cepFim, BigDecimal pesoInicio,
			BigDecimal pesoFim, BigDecimal preco, Integer prazo, BigDecimal gris, BigDecimal adValorem)
	{
		this.zonaTransporte = zonaTransporte;
		this.noTarifa = noTarifa;
		this.valorTaxa = valorTaxa;
		this.meioTransaporte = meioTransaporte;
		this.localidade = localidade;
		this.estado = estado;
		this.ibge = ibge;
		this.cepInicio = cepInicio;
		this.cepFim = cepFim;
		this.pesoInicio = pesoInicio;
		this.pesoFim = pesoFim;
		this.preco = preco;
		this.prazo = prazo;
		this.gris = gris;
		this.adValorem = adValorem;
	}

	public String getZonaTransporte() {
		return zonaTransporte;
	}

	public void setZonaTransporte(String zonaTransporte) {
		this.zonaTransporte = zonaTransporte;
	}

	public String getNoTarifa() {
		return noTarifa;
	}

	public void setNoTarifa(String noTarifa) {
		this.noTarifa = noTarifa;
	}

	public BigDecimal getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(BigDecimal valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public String getMeioTransaporte() {
		return meioTransaporte;
	}

	public void setMeioTransaporte(String meioTransaporte) {
		this.meioTransaporte = meioTransaporte;
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

	public Long getIbge() {
		return ibge;
	}

	public void setIbge(Long ibge) {
		this.ibge = ibge;
	}

	public String getCepInicio() {
		return cepInicio;
	}

	public void setCepInicio(String cepInicio) {
		this.cepInicio = cepInicio;
	}

	public String getCepFim() {
		return cepFim;
	}

	public void setCepFim(String cepFim) {
		this.cepFim = cepFim;
	}

	public BigDecimal getPesoInicio() {
		return pesoInicio;
	}

	public void setPesoInicio(BigDecimal pesoInicio) {
		this.pesoInicio = pesoInicio;
	}

	public BigDecimal getPesoFim() {
		return pesoFim;
	}

	public void setPesoFim(BigDecimal pesoFim) {
		this.pesoFim = pesoFim;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public BigDecimal getGris() {
		return gris;
	}

	public void setGris(BigDecimal gris) {
		this.gris = gris;
	}

	public BigDecimal getAdValorem() {
		return adValorem;
	}

	public void setAdValorem(BigDecimal adValorem) {
		this.adValorem = adValorem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LinhaTabelaFreteVo [zonaTransporte=" + zonaTransporte + ", noTarifa=" + noTarifa + ", valorTaxa="
				+ valorTaxa + ", meioTransaporte=" + meioTransaporte + ", localidade=" + localidade + ", estado="
				+ estado + ", ibge=" + ibge + ", cepInicio=" + cepInicio + ", cepFim=" + cepFim + ", pesoInicio="
				+ pesoInicio + ", pesoFim=" + pesoFim + ", preco=" + preco + ", prazo=" + prazo + ", gris=" + gris
				+ ", adValorem=" + adValorem + "]";
	}
}
