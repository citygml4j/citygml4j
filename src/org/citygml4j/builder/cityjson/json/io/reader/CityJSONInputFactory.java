package org.citygml4j.builder.cityjson.json.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

public class CityJSONInputFactory {
	
	public CityJSONReader createCityJSONReader(File file) throws CityJSONReadException {
		try {
			JsonReader reader = new JsonReader(new BufferedReader(new FileReader(file)));
			return new CityJSONReader(reader);
		} catch (FileNotFoundException e) {
			throw new CityJSONReadException("Caused by: ", e);
		}
	}

	public CityJSONReader createCityJSONReader(InputStream stream) throws CityJSONReadException {
		JsonReader reader = new JsonReader(new InputStreamReader(stream));
		return new CityJSONReader(reader);
	}
	
	public CityJSONReader createFilteredCityJSONReader(CityJSONReader reader, CityJSONInputFilter filter) throws CityJSONReadException {
		reader.setInputFilter(filter);
		return reader;
	}

}
