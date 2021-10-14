package com.jequiti.plataforma.integracao.gko.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Ocorrencia implements Serializable{
	private static final long serialVersionUID = 9111678890757589237L;
	
	private Long pedido;
	private String dsTipoOcorrencia;
	private Integer cdTipoOcorrencia;
	private Integer cdProceda;
	private String txObservacao;
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone="GMT-3")
	private Date dtOcorrencia;
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone="GMT-3")
	private Date dtRegistro;
	private Long cdTransportadora;
	private String dsApelidoTransportadora;
	
	public Long getPedido() {
		return pedido;
	}
	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}
	public String getDsTipoOcorrencia() {
		return dsTipoOcorrencia;
	}
	public void setDsTipoOcorrencia(String dsTipoOcorrencia) {
		this.dsTipoOcorrencia = dsTipoOcorrencia;
	}
	public Integer getCdTipoOcorrencia() {
		return cdTipoOcorrencia;
	}
	public void setCdTipoOcorrencia(Integer cdTipoOcorrencia) {
		this.cdTipoOcorrencia = cdTipoOcorrencia;
	}
	public Integer getCdProceda() {
		return cdProceda;
	}
	public void setCdProceda(Integer cdProceda) {
		this.cdProceda = cdProceda;
	}
	public String getTxObservacao() {
		return txObservacao;
	}
	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}
	public Date getDtOcorrencia() {
		return dtOcorrencia;
	}
	public void setDtOcorrencia(Date dtOcorrencia) {
		this.dtOcorrencia = dtOcorrencia;
	}
	public Date getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	public Long getCdTransportadora() {
		return cdTransportadora;
	}
	public void setCdTransportadora(Long cdTransportadora) {
		this.cdTransportadora = cdTransportadora;
	}
	public String getDsApelidoTransportadora() {
		return dsApelidoTransportadora;
	}
	public void setDsApelidoTransportadora(String dsApelidoTransportadora) {
		this.dsApelidoTransportadora = dsApelidoTransportadora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Ocorrencia [pedido=" + pedido + ", dsTipoOcorrencia=" + dsTipoOcorrencia + ", cdTipoOcorrencia="
				+ cdTipoOcorrencia + ", cdProceda=" + cdProceda + ", txObservacao=" + txObservacao + ", dtOcorrencia="
				+ dtOcorrencia + ", dtRegistro=" + dtRegistro + ", cdTransportadora=" + cdTransportadora
				+ ", dsApelidoTransportadora=" + dsApelidoTransportadora + "]";
	}
}
