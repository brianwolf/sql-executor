package ar.gov.anses.sidu.entity;

import java.util.List;
import java.util.Map;

public class StoreProcedure {

	private String name;

	private Map<String, Object> parametersMap;

	private String schema;

	private String db;

	private List<String> resultColumns;

	public StoreProcedure() {
		super();
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getParametersMap() {
		return parametersMap;
	}

	public void setParametersMap(Map<String, Object> parametersMap) {
		this.parametersMap = parametersMap;
	}

	public List<String> getResultColumns() {
		return resultColumns;
	}

	public void setResultColumns(List<String> resultColumns) {
		this.resultColumns = resultColumns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parametersMap == null) ? 0 : parametersMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreProcedure other = (StoreProcedure) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parametersMap == null) {
			if (other.parametersMap != null)
				return false;
		} else if (!parametersMap.equals(other.parametersMap))
			return false;
		return true;
	}

}
