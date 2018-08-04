package ar.gov.anses.sidu.exception;

import org.springframework.http.HttpStatus;

import ar.gov.anses.sidu.exception.response.AExceptionResponse;
import ar.gov.anses.sidu.exception.response.BasicExceptionResponse;

public class SiduException extends Exception {

	private static final long serialVersionUID = 7802372974410182137L;

	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	private AExceptionResponse exceptionResponse = new BasicExceptionResponse();

	public SiduException() {
		super();
	}

	public SiduException(HttpStatus httpStatus, AExceptionResponse exceptionResponse) {
		super();
		this.httpStatus = httpStatus;
		this.exceptionResponse = exceptionResponse;
	}

	public SiduException(AExceptionResponse exceptionResponse) {
		super();
		this.exceptionResponse = exceptionResponse;
	}

	public SiduException(String errorMessage) {
		super();
		this.exceptionResponse.setErrorMessage(errorMessage);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public AExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(AExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}

}
