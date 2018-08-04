package ar.gov.anses.sidu.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ar.gov.anses.sidu.entity.StoreProcedure;
import ar.gov.anses.sidu.exception.SiduException;

@Repository
public interface ExecuterRepository {

	List<Map<String, Object>> exec(StoreProcedure storeProcedure) throws SiduException;

}
