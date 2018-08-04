package ar.gov.anses.sidu.exception.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.gov.anses.sidu.entity.BusinessExceptionBuilder;

public class TableExceptionResponce extends AExceptionResponse {

	private List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

	public List<Map<String, Object>> getResult() {
		return result;
	}

	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}

	@Override
	public void buildBusinessResponse(List<Map<String, Object>> queryResult) {
		super.buildGenericBusinessResponse(queryResult);

		for (Map<String, Object> map : queryResult) {
			map.remove(BusinessExceptionBuilder.BUSINESS_ERROR);
			map.remove(BusinessExceptionBuilder.MESSAGE_ERROR);
			map.remove(BusinessExceptionBuilder.TYPE_ERROR);
		}
		setResult(queryResult);
	}
}
