package org.citygml4j.builder.cityjson.json.io.reader;

import java.io.IOException;
import java.util.List;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeAdapter;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.BoundingShape;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class CityJSONReader implements AutoCloseable {
	private final JsonReader reader;
	private final GsonBuilder builder;
	private final CityJSONUnmarshaller unmarshaller;
	
	private MetadataType metadata;

	public CityJSONReader(JsonReader reader, CityJSONInputFactory factory) {
		this.reader = reader;
		
		builder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
		unmarshaller = new CityJSONUnmarshaller(factory.textureFileHandler);
	}

	public CityModel read() {
		CityJSON cityJSON = builder.create().fromJson(reader, CityJSON.class);
		if (cityJSON != null) {
			metadata = cityJSON.getMetadata();
			CityModel cityModel = unmarshaller.unmarshal(cityJSON);
			
			if (metadata != null) {
				if (metadata.isSetBBox()) {
					List<Double> bbox = metadata.getBBox();
					if (bbox.size() > 5) {
						BoundingShape boundedBy = new BoundingShape();
						boundedBy.setEnvelope(new BoundingBox(
								new Point(bbox.get(0), bbox.get(1), bbox.get(2)), 
								new Point(bbox.get(3), bbox.get(4), bbox.get(5))));
						
						if (metadata.isSetCRS())
							boundedBy.getEnvelope().setSrsName(new StringBuilder("EPSG:").append(metadata.getCRS().getEpsg()).toString());
						
						cityModel.setBoundedBy(boundedBy);
					}
				}
			}
			
			return cityModel;
		}
		
		return null;
	}
	
	public boolean isSetMetadata() {
		return metadata != null;
	}
	
	public MetadataType getMetadata() {
		return metadata;
	}

	protected void setInputFilter(CityObjectTypeFilter filter) {
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
