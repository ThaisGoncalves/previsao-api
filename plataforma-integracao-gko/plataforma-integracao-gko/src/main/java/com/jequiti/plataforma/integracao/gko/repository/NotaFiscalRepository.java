package com.jequiti.plataforma.integracao.gko.repository;


import java.util.Date;
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

import com.jequiti.plataforma.integracao.gko.entity.NotaFiscal;

import oracle.jdbc.OracleTypes;

@Repository
public class NotaFiscalRepository {
	private static final Logger logger = LoggerFactory.getLogger(FreightPriceRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	public List<NotaFiscal> getNotasSemPPE() {
		logger.info("Chamando a procedure de leitura de notas fiscais sem previsão de entrega");

		List<NotaFiscal> notasFiscais = null;

		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PROCAPI")
				.withCatalogName("PROCAPI_JQT_GKO_INTEGRATION").withProcedureName("PRC_LE_NOTA_SEM_PPE")
				.withoutProcedureColumnMetaDataAccess().declareParameters(
						new SqlOutParameter("X_NFS_S_PPE", OracleTypes.CURSOR,
								BeanPropertyRowMapper.newInstance(NotaFiscal.class)),
						new SqlOutParameter("W_STS_CODE", OracleTypes.VARCHAR),
						new SqlOutParameter("W_MSG", OracleTypes.VARCHAR));

		// SqlParameterSource inPutParameters = new
		// MapSqlParameterSource().addValue("P_CODIGO_PEDIDO", codigoPedido);

		notasFiscais = jdbcCall.executeObject(List.class, new MapSqlParameterSource());
		return notasFiscais;
	}

	public NotaFiscal postNotasSemPPE(Long idntaembarque, Date dtPrevisaoEntega) {
		logger.info("Chamando a procedure de atualização de notas fiscais sem previsão de entrega");

		List<NotaFiscal> notasFiscais = null;

		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PROCAPI")
				.withCatalogName("PROCAPI_JQT_GKO_INTEGRATION").withProcedureName("PRC_ATU_DATA_PREV_ENTREGA")
				.withoutProcedureColumnMetaDataAccess().declareParameters(
						new SqlParameter("P_ID_EMBARQUE", OracleTypes.NUMBER),
						new SqlParameter("P_NOVA_DT_ENTREGA", OracleTypes.DATE),
						
						new SqlOutParameter("X_NFS_S_PPE", OracleTypes.CURSOR,
								BeanPropertyRowMapper.newInstance(NotaFiscal.class)),
						new SqlOutParameter("W_STS_CODE", OracleTypes.VARCHAR),
						new SqlOutParameter("W_MSG", OracleTypes.VARCHAR));

		SqlParameterSource inPutParameters = new MapSqlParameterSource().addValue("P_ID_EMBARQUE", idntaembarque)
				.addValue("P_NOVA_DT_ENTREGA", dtPrevisaoEntega);

		notasFiscais = jdbcCall.executeObject(List.class, inPutParameters);
		
		for ( NotaFiscal notaFiscal : notasFiscais) {
			return notaFiscal;
		}
		return null;
	}
}
