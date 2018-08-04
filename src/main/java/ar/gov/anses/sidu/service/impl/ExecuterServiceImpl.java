package ar.gov.anses.sidu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.gov.anses.sidu.entity.StoreProcedure;
import ar.gov.anses.sidu.exception.SiduException;
import ar.gov.anses.sidu.repository.ExecuterRepository;
import ar.gov.anses.sidu.service.ExecuteService;

@Component
public class ExecuterServiceImpl implements ExecuteService {

	@Autowired
	private ExecuterRepository executerRepository;

	@Override
	public List<Map<String, Object>> execGeneric(StoreProcedure storeProcedure) throws SiduException {
		return this.executerRepository.exec(storeProcedure);
	}

	@Override
	public List<Map<String, Object>> exec(StoreProcedure storeProcedure) throws SiduException {

		return this.executerRepository.exec(storeProcedure);
	}
}
