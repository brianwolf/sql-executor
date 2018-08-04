package ar.gov.anses.sidu.exception.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.gov.anses.sidu.entity.BusinessExceptionBuilder;
import ar.gov.anses.sidu.exception.SiduException;

public abstract class AExceptionResponse {

	private static final String ERROR_MESSAGE_DEFAULT = "Sidu-jlib Error";

	private static Map<String, Class<? extends AExceptionResponse>> mapExceptionResponse = loaderMapExceptionResponse();

	private static Map<String, Class<? extends AExceptionResponse>> loaderMapExceptionResponse() {

		Map<String, Class<? extends AExceptionResponse>> mapresult = new HashMap<String, Class<? extends AExceptionResponse>>();
		mapresult.put(BasicExceptionResponse.class.getSimpleName(), BasicExceptionResponse.class);
		mapresult.put(TableExceptionResponce.class.getSimpleName(), TableExceptionResponce.class);
		mapresult.put(SingleListExceptionResponce.class.getSimpleName(), SingleListExceptionResponce.class);

		return mapresult;
	}

	protected String errorMessage;

	protected String errorType;

	public AExceptionResponse() {
		this.setErrorMessage(ERROR_MESSAGE_DEFAULT);
		this.setErrorType(SiduException.class.getSimpleName());
	}

	public AExceptionResponse(String exceptionTypeName, String errorMessage) {
		this.setErrorMessage(errorMessage);
		this.setErrorType(exceptionTypeName);
	}

	public static Map<String, Class<? extends AExceptionResponse>> getMap() {
		return mapExceptionResponse;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	protected void buildGenericBusinessResponse(List<Map<String, Object>> queryResult) {
		this.setErrorType((String) queryResult.get(BusinessExceptionBuilder.BUSINESS_ERROR_INDEX)
				.get(BusinessExceptionBuilder.TYPE_ERROR));
		this.setErrorMessage((String) queryResult.get(BusinessExceptionBuilder.BUSINESS_ERROR_INDEX)
				.get(BusinessExceptionBuilder.MESSAGE_ERROR));
	}

	public abstract void buildBusinessResponse(List<Map<String, Object>> queryResult);
}
