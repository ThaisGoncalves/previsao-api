package com.jequiti.atualiza.previsao.entrega.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jequiti.atualiza.previsao.entrega.dto.NotasFiscais;
import com.jequiti.atualiza.previsao.entrega.dto.wms.Fatura;
import com.jequiti.atualiza.previsao.entrega.dto.wms.Pedido;
import com.jequiti.atualiza.previsao.entrega.dto.wms.PedidoFatura;
import com.jequiti.atualiza.previsao.entrega.service.ClienteGkoRestService;
import com.jequiti.atualiza.previsao.entrega.service.ClienteWmsRestService;
import com.jequiti.atualiza.previsao.entrega.service.impl.ClienteWmsRestServiceImpl;

@RestController
public class AtualizaPrevisaoEntregaController {
	private static final Logger logger = LoggerFactory.getLogger(AtualizaPrevisaoEntregaController.class);

	private ClienteGkoRestService gkoRestService;
	private ClienteWmsRestService wmsRestService;

	@Autowired
	public AtualizaPrevisaoEntregaController(ClienteGkoRestService gkoRestService, ClienteWmsRestService wmsRestServce,
			ClienteWmsRestService wmsRestService) {

		this.gkoRestService = gkoRestService;
		this.wmsRestService = wmsRestService;
	}

	@Autowired
	ClienteWmsRestServiceImpl _clienteWmsRestServiceImpl;

	@PostMapping("/teste")
	public void atualizaNotasFiscaisSemPrevisaoEntrega() throws Exception {
		logger.info("INICIO");

		NotasFiscais[] listaNotasFiscais = gkoRestService.buscarFaturaGkoSemPPE();

		for (NotasFiscais notasFiscais : listaNotasFiscais) {
			logger.info("nota fiscal: {} ", notasFiscais.getCdNota());
			Fatura faturaWms = wmsRestService.findByNumeroNotaFiscal(notasFiscais.getCdNota());

			if (faturaWms != null) {

				PedidoFatura pedidoFatura = this._clienteWmsRestServiceImpl
						.findByCodigoTitulo(faturaWms.getCodigoTitulo());
				Pedido pedido = this._clienteWmsRestServiceImpl.findByCodigoPedido(pedidoFatura.getCodigoPedido());

				logger.info("idEmbarque: {} ", notasFiscais.getIdntaembarque());
				Map<String, String> value = new HashMap<String, String>();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dataPrevisaoEntrega = format.format(notasFiscais.getDtPrevisaoEntrega());
				value.put("dtPrevisaoEntrega", pedido.getDataPrevisao().toString());
				value.put("idNtaEmbarque", notasFiscais.getIdntaembarque().toString());

				this.gkoRestService.atualizaNotasFiscaisSemPrevisaoEntrega(value);
			}
		}

		logger.info("FIM");
	}

}
