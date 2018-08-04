package ar.gov.anses.sidu.repository.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ar.gov.anses.sidu.entity.BusinessExceptionBuilder;
import ar.gov.anses.sidu.entity.QueryBuilder;
import ar.gov.anses.sidu.entity.StoreProcedure;
import ar.gov.anses.sidu.exception.SiduException;
import ar.gov.anses.sidu.repository.ExecuterRepository;

@Transactional
@Repository
public class ExecuterRepositoryImpl implements ExecuterRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExecuterRepositoryImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Map<String, Object>> execGeneric(StoreProcedure storeProcedure) throws SiduException {
		
		String query = QueryBuilder.getStringQuery(storeProcedure);
		LOG.info("Query: " + query + " Parameters: " + storeProcedure.getParametersMap().toString());
		
		return namedParameterJdbcTemplate.queryForList(query, storeProcedure.getParametersMap());
	}

	public List<Map<String, Object>> exec(StoreProcedure storeProcedure) throws SiduException {

		List<Map<String, Object>> result = execGeneric(storeProcedure);
		if (BusinessExceptionBuilder.isASiduException(result)) {
			throw BusinessExceptionBuilder.build(result);
		}

		return result;
	}
}
