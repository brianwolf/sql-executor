package ar.gov.anses.sidu.service;

import java.util.List;
import java.util.Map;

import ar.gov.anses.sidu.entity.StoreProcedure;
import ar.gov.anses.sidu.exception.SiduException;

public interface ExecuteService {

	List<Map<String, Object>> execGeneric(StoreProcedure storeProcedure) throws SiduException;
	
	List<Map<String, Object>> exec(StoreProcedure storeProcedure) throws SiduException;
}
