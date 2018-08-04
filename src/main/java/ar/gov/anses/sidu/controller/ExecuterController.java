package ar.gov.anses.sidu.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.gov.anses.sidu.entity.StoreProcedure;
import ar.gov.anses.sidu.exception.SiduException;
import ar.gov.anses.sidu.service.ExecuteService;

@RestController()
public class ExecuterController {

	private static final Logger LOG = LoggerFactory.getLogger(ExecuterController.class);

	@Autowired
	private ExecuteService executeService;

	@GetMapping("/alive")
	public String status() {
		return "esta vivito!";
	}

	@PostMapping("/execute/generic/sp")
	public ResponseEntity<Object> exec(@RequestBody StoreProcedure storeProcedure) {

		try {
			List<Map<String, Object>> result = this.executeService.execGeneric(storeProcedure);

			if (result.isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch (SiduException siduException) {
			return new ResponseEntity<Object>(siduException.getExceptionResponse(), siduException.getHttpStatus());

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/execute/sp")
	public ResponseEntity<Object> execSIDU(@RequestBody StoreProcedure storeProcedure) {

		try {
			List<Map<String, Object>> result = this.executeService.execGeneric(storeProcedure);

			if (result.isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch (SiduException siduException) {
			return new ResponseEntity<Object>(siduException.getExceptionResponse(), siduException.getHttpStatus());

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}