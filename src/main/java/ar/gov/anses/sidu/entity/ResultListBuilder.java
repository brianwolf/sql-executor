package ar.gov.anses.sidu.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultListBuilder {

	public static final String DEFAULT_COLUM_NAME = "column";

	private static Map<String, Object> buildColumnResult(Object columnValue, List<String> columnsKey) {

		Map<String, Object> mapResult = new HashMap<String, Object>();

		boolean haveKeys = columnsKey != null && !columnsKey.isEmpty();
		if (columnValue instanceof Object[]) {
			for (int i = 0; i < ((Object[]) columnValue).length; i++) {

				String columnName = haveKeys && columnsKey.size() - 1 >= i ? columnsKey.get(i) : DEFAULT_COLUM_NAME + (i + 1);
				mapResult.put(columnName, ((Object[]) columnValue)[i]);
			}
		} else {
			mapResult.put(haveKeys ? columnsKey.get(0) : DEFAULT_COLUM_NAME, columnValue);
		}

		return mapResult;
	}

	public static List<Map<String, Object>> buildMapResult(List<Object[]> resultList, List<String> resultColumns){

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		for (Object listObj : resultList) {
			Map<String, Object> mapColumn = buildColumnResult(listObj, resultColumns);
			listMap.add(mapColumn);
		}

		return listMap;
	}
	
	public static List<Map<String, Object>> buildMapResult(List<Object[]> resultList){
		return buildMapResult(resultList, null);
	}
}
