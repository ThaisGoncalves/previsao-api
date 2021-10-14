package com.jequiti.plataforma.integracao.gko.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.gko.ebs.entity.ApiRetornos;
import com.jequiti.plataforma.integracao.gko.entity.Ocorrencia;
import com.jequiti.plataforma.integracao.gko.entity.TabelaFrete;
import com.jequiti.plataforma.integracao.gko.entity.Transportadora;

import oracle.jdbc.OracleTypes;

@Repository
public class FreightPriceRepository {
	private static final Logger logger = LoggerFactory.getLogger(FreightPriceRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;
	
	public List<TabelaFrete> getFreightPriceTable(Long codigoTransportadora, String localidade) 
	{
		//ApiRetornos apiRetornos =  new ApiRetornos();
		List<TabelaFrete> tabelaFretes = new ArrayList<>();

		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PROCAPI")
				.withCatalogName("PROCAPI_JQT_GKO_INTEGRATION").withProcedureName("PRC_LE_TABELA_PRECO")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("P_COD_TRANSPORTADORA", OracleTypes.NUMBER),
						new SqlParameter("P_LOCALIDADE", OracleTypes.VARCHAR),
						new SqlOutParameter("X_PRICE_TABS", OracleTypes.CURSOR,
								BeanPropertyRowMapper.newInstance(TabelaFrete.class)),
						new SqlOutParameter("W_STS_CODE", OracleTypes.VARCHAR),
						new SqlOutParameter("W_MSG", OracleTypes.VARCHAR));

		SqlParameterSource inPutParameters = new MapSqlParameterSource()
				.addValue("P_COD_TRANSPORTADORA", codigoTransportadora).addValue("P_LOCALIDADE", localidade);

		tabelaFretes = jdbcCall.executeObject(List.class, inPutParameters);

		return tabelaFretes;
	}
	
	public List<Transportadora> getCarrier(String cnpj)
	{
		List<Transportadora> transportadoras = null;
		
		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PROCAPI")
				.withCatalogName("PROCAPI_JQT_GKO_INTEGRATION").withProcedureName("PRC_LE_TRANSPORTADORA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("P_CNPJ", OracleTypes.VARCHAR),
						new SqlOutParameter("X_RC_TRANSP", OracleTypes.CURSOR,
								BeanPropertyRowMapper.newInstance(Transportadora.class)),
						new SqlOutParameter("W_STS_CODE", OracleTypes.VARCHAR),
						new SqlOutParameter("W_MSG", OracleTypes.VARCHAR));

		SqlParameterSource inPutParameters = new MapSqlParameterSource()
				.addValue("P_CNPJ", cnpj);

		transportadoras = jdbcCall.executeObject(List.class, inPutParameters);

		return transportadoras;
	}
	
	public List<Ocorrencia> getOccurrences(String codigoPedido) {
		
		List<Ocorrencia> ocorrencias = null;
		
		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PROCAPI")
				.withCatalogName("PROCAPI_JQT_GKO_INTEGRATION").withProcedureName("PRC_LE_OCORRENCIA_PEDIDO")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlParameter("P_CODIGO_PEDIDO", OracleTypes.VARCHAR),
						new SqlOutParameter("X_OCORR_PEDIDO", OracleTypes.CURSOR,
								BeanPropertyRowMapper.newInstance(Ocorrencia.class)),
						new SqlOutParameter("W_STS_CODE", OracleTypes.VARCHAR),
						new SqlOutParameter("W_MSG", OracleTypes.VARCHAR));
		
		
		SqlParameterSource inPutParameters = new MapSqlParameterSource()
				.addValue("P_CODIGO_PEDIDO", codigoPedido);
		
		ocorrencias =  jdbcCall.executeObject(List.class, inPutParameters);
		return ocorrencias;
	}

}
