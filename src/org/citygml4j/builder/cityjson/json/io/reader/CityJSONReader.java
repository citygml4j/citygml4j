package org.citygml4j.builder.cityjson.json.io.reader;

import java.io.IOException;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeAdapter;
import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.core.CityModel;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class CityJSONReader implements AutoCloseable {
	private final JsonReader reader;
	private final GsonBuilder builder;
	private final CityJSONUnmarshaller unmarshaller;
	
	private MetadataType metadata;

	public CityJSONReader(JsonReader reader) {
		this.reader = reader;
		
		builder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
		unmarshaller = new CityJSONUnmarshaller();
	}

	public CityModel read() {
		CityJSON cityJSON = builder.create().fromJson(reader, CityJSON.class);
		if (cityJSON != null) {
			metadata = cityJSON.getMetadata();
			return unmarshaller.unmarshal(cityJSON);
		}
		
		return null;
	}
	
	public boolean isSetMetadata() {
		return metadata != null;
	}
	
	public MetadataType getMetadata() {
		return metadata;
	}

	protected void setInputFilter(CityJSONInputFilter filter) {
		builder.registerTypeAdapter(AbstractCityObjectType.class, new CityObjectTypeAdapter(filter));
	}
	
	@Override
	public void close() throws CityJSONReadException {
		try {
			metadata = null;
			reader.close();
		} catch (IOException e) {
			throw new CityJSONReadException("Caused by: ", e);
		}
	}

}
