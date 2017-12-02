package org.citygml4j.builder.cityjson.json.io.writer;

import java.io.IOException;

import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

public abstract class AbstractCityJSONWriter implements AutoCloseable {
	protected final JsonWriter writer;
	protected final CityJSONMarshaller marshaller;
	protected final Gson gson;
	
	protected MetadataType metadata;
	
	public AbstractCityJSONWriter(JsonWriter writer, CityJSONOutputFactory factory) {
		this.writer = writer;
				
		marshaller = new CityJSONMarshaller(factory.verticesBuilder, factory.textureVerticesBuilder);		
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	}

	public MetadataType getMetadata() {
		return metadata;
	}

	public void setMetadata(MetadataType metadata) {
		this.metadata = metadata;
	}

	public void setIndent(String indent) {
		writer.setIndent(indent);
	}
	
	public boolean isHtmlSafe() {
		return writer.isHtmlSafe();
	}
	
	public void setHtmlSafe(boolean htmlSafe) {
		writer.setHtmlSafe(htmlSafe);
	}
	
	public void flush() throws CityJSONWriteException {
		try {
			writer.flush();
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}
	
	public void close() throws CityJSONWriteException {
		try {
			writer.close();
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}
	
}
