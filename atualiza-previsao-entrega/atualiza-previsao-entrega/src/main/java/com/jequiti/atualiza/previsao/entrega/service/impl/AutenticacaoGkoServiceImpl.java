package com.jequiti.atualiza.previsao.entrega.service.impl;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.jequiti.atualiza.previsao.entrega.dto.AutenticacaoGkoDTO;
import com.jequiti.atualiza.previsao.entrega.dto.Parametros;
import com.jequiti.atualiza.previsao.entrega.exception.PrincipalException;
import com.jequiti.atualiza.previsao.entrega.service.AutenticacaoGkoService;
import com.jequiti.atualiza.previsao.entrega.service.ParametrosService;

@Service
public class AutenticacaoGkoServiceImpl implements AutenticacaoGkoService {

	private static final Logger LOG = LoggerFactory.getLogger(AutenticacaoGkoService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ParametrosService parametrosService;

	@Override
	public AutenticacaoGkoDTO autenticaGko() throws Exception {

		Parametros parametros = this.parametrosService.buscarParametros();

		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(parametros.getClientId(), parametros.getPassword());
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.setAccept(Arrays.asList(MediaType.MULTIPART_FORM_DATA));

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", parametros.getAuthType());
		map.add("username", parametros.getUsername());
		map.add("password", parametros.getPassword());
		map.add("client_id", parametros.getClientId());

		HttpEntity<MultiValueMap<String, String>> params = new HttpEntity<>(map, headers);

		System.out.println("passou aqui tb..HttpEntity");

		ResponseEntity<AutenticacaoGkoDTO> response = restTemplate.postForEntity(parametros.getAuthenticationUrl(),
				params, AutenticacaoGkoDTO.class);

		if (response.getStatusCode() == HttpStatus.OK)
			return response.getBody();
		else
			throw new PrincipalException(response.getBody().toString());
	}

}
