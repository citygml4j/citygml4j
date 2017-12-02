package org.citygml4j.builder.cityjson;

import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;

public class CityJSONBuilder {

	public CityJSONInputFactory createCityJSONInputFactory() throws CityJSONBuilderException {
		return new CityJSONInputFactory();
	}
	
}
