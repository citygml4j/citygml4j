package org.citygml4j.builder.cityjson;

import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.TextureFileHandler;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;

public class CityJSONBuilder {

	public CityJSONUnmarshaller createCityJSONUnmarshaller() {
		return new CityJSONUnmarshaller();
	}
	
	public CityJSONMarshaller createCityJSONMarshaller() {
		return new CityJSONMarshaller();
	}
	
	public CityJSONMarshaller createCityJSONMarshaller(VerticesBuilder verticesBuilder, TextureVerticesBuilder textureVerticesBuilder, TextureFileHandler textureFileHandler) {
		return new CityJSONMarshaller(verticesBuilder, textureVerticesBuilder, textureFileHandler);
	}
	
	public CityJSONInputFactory createCityJSONInputFactory() throws CityJSONBuilderException {
		return new CityJSONInputFactory();
	}
	
	public CityJSONOutputFactory createCityJSONOutputFactory() throws CityJSONBuilderException {
		return new CityJSONOutputFactory();
	}
	
}
