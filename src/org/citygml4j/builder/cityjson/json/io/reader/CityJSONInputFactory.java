package org.citygml4j.builder.cityjson.json.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.citygml4j.binding.cityjson.feature.CityObjectTypeFilter;

import com.google.gson.stream.JsonReader;

public class CityJSONInputFactory {
	
	public CityJSONReader createCityJSONReader(File file) throws CityJSONReadException {
		try {
			return new CityJSONReader(new JsonReader(new BufferedReader(new FileReader(file))));
		} catch (FileNotFoundException e) {
			throw new CityJSONReadException("Caused by: ", e);
		}
	}

	public CityJSONReader createCityJSONReader(InputStream inputStream) throws CityJSONReadException {
		return new CityJSONReader(new JsonReader(new InputStreamReader(inputStream)));
	}
	
	public CityJSONReader createFilteredCityJSONReader(CityJSONReader reader, CityObjectTypeFilter filter) throws CityJSONReadException {
		reader.setInputFilter(filter);
		return reader;
	}

}
