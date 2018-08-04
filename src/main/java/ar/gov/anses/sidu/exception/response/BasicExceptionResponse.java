package ar.gov.anses.sidu.exception.response;

import java.util.List;
import java.util.Map;

public class BasicExceptionResponse extends AExceptionResponse {

	public BasicExceptionResponse() {
		super();
	}
	
	public BasicExceptionResponse(String errorMessage, String exceptionTypeName) {
		super();
		this.setErrorMessage(errorMessage);
		this.setErrorType(exceptionTypeName);
	}

	@Override
	public void buildBusinessResponse(List<Map<String, Object>> queryResult) {
		super.buildGenericBusinessResponse(queryResult);
	}
}
