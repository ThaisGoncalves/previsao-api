package com.jequiti.atualiza.previsao.entrega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jequiti.atualiza.previsao.entrega.client.JequitiClient;
import com.jequiti.atualiza.previsao.entrega.dto.Parametros;
import com.jequiti.atualiza.previsao.entrega.service.ParametrosService;

@Service
public class ParametrosServiceImpl implements ParametrosService {

	@Autowired
	private JequitiClient clientJequiti;

	@Override
	public Parametros buscarParametros() {
		// TODO Auto-generated method stub

		Parametros retorno = null;

		try {

			// Properties prop = getProp();
			retorno = new Parametros();

			retorno.setAuthenticationUrl(clientJequiti.plataformaJequitiOauthUri);
			retorno.setAuthType(clientJequiti.plataformaJequitiApiGrantType);
			retorno.setClientId(clientJequiti.plataformaJequitiApiClientId);
			retorno.setPassword(clientJequiti.plataformaJequitiApiUserPassword);
			retorno.setPasswordApi(clientJequiti.plataformaJequitiApiPassword);
			retorno.setUsername(clientJequiti.plataformaJequitiApiUser);

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

		return retorno;
	}

}
