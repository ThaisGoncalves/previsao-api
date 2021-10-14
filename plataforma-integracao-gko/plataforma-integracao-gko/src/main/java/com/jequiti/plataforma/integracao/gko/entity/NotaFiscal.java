package com.jequiti.plataforma.integracao.gko.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NotaFiscal {
	
	private Long idNota;
	private Long idntaembarque;
	private String cdNota;
	private String cdSerie;
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone="GMT-3")
	private Date dtEmissao;
	private String dsChaveAcesso;
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone="GMT-3")
	private Date dtPrevisaoEntrega;	
	
	public Long getIdNota() {
		return idNota;
	}
	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}
	public Long getIdntaembarque() {
		return idntaembarque;
	}
	public void setIdntaembarque(Long idntaembarque) {
		this.idntaembarque = idntaembarque;
	}
	public String getCdNota() {
		return cdNota.trim();
	}
	public void setCdNota(String cdNota) {
		this.cdNota = cdNota;
	}
	public String getCdSerie() {
		return cdSerie.trim();
	}
	public void setCdSerie(String cdSerie) {
		this.cdSerie = cdSerie;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getDsChaveAcesso() {
		return dsChaveAcesso;
	}
	public void setDsChaveAcesso(String dsChaveAcesso) {
		this.dsChaveAcesso = dsChaveAcesso;
	}
	public Date getDtPrevisaoEntrega() {
		return dtPrevisaoEntrega;
	}
	public void setDtPrevisaoEntrega(Date dtPrevisaoEntrega) {
		this.dtPrevisaoEntrega = dtPrevisaoEntrega;
	}

	@Override
	public String toString() {
		return "NotaFiscal [idNota=" + idNota + ", cdNota=" + cdNota + ", cdSerie=" + cdSerie + ", dtEmissao="
				+ dtEmissao + ", dsChaveAcesso=" + dsChaveAcesso + ", dtPrevisaoEntrega=" + dtPrevisaoEntrega + "]";
	}
}
