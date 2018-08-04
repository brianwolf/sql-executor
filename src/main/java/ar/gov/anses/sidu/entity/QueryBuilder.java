package ar.gov.anses.sidu.entity;

public class QueryBuilder {

	public static String getStringQuery(StoreProcedure storeProcedure) {

		String stringQuery = getSPQueryName(storeProcedure);

		if (storeProcedure.getParametersMap() == null)
			return stringQuery;

		for (String parameterName : storeProcedure.getParametersMap().keySet()) {
			stringQuery += (" :" + parameterName + ",");
		}
		stringQuery = stringQuery.substring(0, stringQuery.length() - 1);

		return stringQuery;
	}

	public static String getSPQueryName(StoreProcedure storeProcedure) {

		String spQueryName = "";
		spQueryName += storeProcedure.getDb() == null ? "" : storeProcedure.getDb() + ".";
		spQueryName += storeProcedure.getSchema() == null ? "dbo." : storeProcedure.getSchema() + ".";
		spQueryName += storeProcedure.getName();

		return spQueryName;
	}
}
