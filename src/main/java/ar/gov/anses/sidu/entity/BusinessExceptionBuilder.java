package ar.gov.anses.sidu.entity;

import java.util.List;
import java.util.Map;

import ar.gov.anses.sidu.exception.SiduException;
import ar.gov.anses.sidu.exception.response.AExceptionResponse;
import ar.gov.anses.sidu.exception.response.BasicExceptionResponse;

public class BusinessExceptionBuilder {

	public static final String BUSINESS_ERROR = "SIDUException";

	public static final int BUSINESS_ERROR_INDEX = 0;

	public static final String MESSAGE_ERROR = "errorMessage";

	public static final String TYPE_ERROR = "errorType";

	public static final String CLASS_RESPONSE_ERROR = "exceptionResponseClass";

	public static boolean isASiduException(List<Map<String, Object>> queryResult) {
		if (queryResult == null || queryResult.isEmpty()) {
			return false;
		}
		return queryResult.get(BUSINESS_ERROR_INDEX).containsKey(BUSINESS_ERROR);
	}

	public static SiduException build(List<Map<String, Object>> queryResult) {

		AExceptionResponse exceptionResponse = new BasicExceptionResponse();
		
		String classResponceError = (String) queryResult.get(BUSINESS_ERROR_INDEX).get(CLASS_RESPONSE_ERROR);
		if (classResponceError != null) {
			try {
				exceptionResponse = AExceptionResponse.getMap().get(classResponceError).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		exceptionResponse.buildBusinessResponse(queryResult);
		return new SiduException(exceptionResponse);
	}
}
