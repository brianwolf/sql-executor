package ar.gov.anses.sidu.exception.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SingleListExceptionResponce extends AExceptionResponse {

	private static final int KEY_INDEX = 4;
	
	private List<Object> result = new ArrayList<Object>();

	public List<Object> getResult() {
		return result;
	}

	public void setResult(List<Object> result) {
		this.result = result;
	}

	@Override
	public void buildBusinessResponse(List<Map<String, Object>> queryResult) {
		super.buildGenericBusinessResponse(queryResult);
		
		String key = (String) queryResult.get(0).keySet().toArray()[KEY_INDEX];
		queryResult.stream().forEach(m -> getResult().add(m.get(key)));
	}
}
