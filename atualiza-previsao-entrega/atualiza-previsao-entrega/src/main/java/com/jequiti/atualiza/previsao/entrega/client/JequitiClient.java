package com.jequiti.atualiza.previsao.entrega.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;


@Configuration
@Transactional
@Data
public class JequitiClient {

	public @Value("${plataforma.jequiti.api.user}") String plataformaJequitiApiUser;
	public @Value("${plataforma.jequiti.api.user.password}") String plataformaJequitiApiUserPassword;
	public @Value("${plataforma.jequiti.api.grant_type}") String plataformaJequitiApiGrantType;
	public @Value("${plataforma.jequiti.api.client_id}") String plataformaJequitiApiClientId;
	public @Value("${plataforma.jequiti.api.username}") String plataformaJequitiApiUsername;
	public @Value("${plataforma.jequiti.api.password}") String plataformaJequitiApiPassword;

	public @Value("${platafroma.jequiti.api.authenticationUrl}") String plataformaJequitiOauthUri;

	public @Value("${plataforma.jequiti.api.gko.buscarNotaFiscalSemDataEntrega}") String buscarNotaFiscalSemDataEntrega;
	public @Value("${plataforma.jequiti.api.wms.buscarFaturaNumeroNotaFiscal}") String buscarFaturaNumeroNotaFiscal;
	public @Value("${plataforma.jequiti.api.wms.post.url}") String urlPostWms;
}
