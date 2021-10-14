package com.jequiti.plataforma.integracao.gko.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class TabelaFrete implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2105255661402399352L;
	
	private String nmTabela;
	private Date dataInicial;
	private Date dataFinal;
	private Long codTransportadora;
	private String razaoSocial;
	private String codZonaTransporte;
	private String noTrpTarifa;
	private BigDecimal vlrTaxa;
	private String meioTransporte;
	private String localidade;
	private String estado;
	private BigDecimal pesoInicio;
	private BigDecimal pesoFim;
	private String cepInicio;
	private String cepFim;
	private Long ibge;
	private BigDecimal valor;
	private Integer prazo;
	private BigDecimal gris;
	private BigDecimal adValorem;
	
	public String getNmTabela() {
		return nmTabela;
	}
	public void setNmTabela(String nmTabela) {
		this.nmTabela = nmTabela;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Long getCodTransportadora() {
		return codTransportadora;
	}
	public void setCodTransportadora(Long codTransportadora) {
		this.codTransportadora = codTransportadora;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCodZonaTransporte() {
		return codZonaTransporte;
	}
	public void setCodZonaTransporte(String codZonaTransporte) {
		this.codZonaTransporte = codZonaTransporte;
	}
	public String getNoTrpTarifa() {
		return noTrpTarifa;
	}
	public void setNoTrpTarifa(String noTrpTarifa) {
		this.noTrpTarifa = noTrpTarifa;
	}
	public BigDecimal getVlrTaxa() {
		return vlrTaxa;
	}
	public void setVlrTaxa(BigDecimal vlrTaxa) {
		this.vlrTaxa = vlrTaxa;
	}
	public String getMeioTransporte() {
		return meioTransporte;
	}
	public void setMeioTransporte(String meioTransporte) {
		this.meioTransporte = meioTransporte;
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
	public Long getIbge() {
		return ibge;
	}
	public void setIbge(Long ibge) {
		this.ibge = ibge;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		return "TabelaFrete [nmTabela=" + nmTabela + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal
				+ ", codTransportadora=" + codTransportadora + ", razaoSocial=" + razaoSocial + ", codZonaTransporte="
				+ codZonaTransporte + ", noTrpTarifa=" + noTrpTarifa + ", vlrTaxa=" + vlrTaxa + ", meioTransporte="
				+ meioTransporte + ", localidade=" + localidade + ", estado=" + estado + ", pesoInicio=" + pesoInicio
				+ ", pesoFim=" + pesoFim + ", cepInicio=" + cepInicio + ", cepFim=" + cepFim + ", ibge=" + ibge
				+ ", valor=" + valor + ", prazo=" + prazo + ", gris=" + gris + ", adValorem=" + adValorem + "]";
	}
}
	
