/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.cityjson.json.io.reader;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeAdapter;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.BoundingShape;

import java.io.IOException;
import java.util.List;

public class CityJSONReader implements AutoCloseable {
	private final JsonReader reader;
	private final GsonBuilder builder;
	private final CityJSONUnmarshaller unmarshaller;
	
	private MetadataType metadata;

	public CityJSONReader(JsonReader reader, CityJSONInputFactory factory) {
		this.reader = reader;
		
		builder = new GsonBuilder();
		unmarshaller = new CityJSONUnmarshaller(factory.textureFileHandler);
	}

	public CityModel read() {
		CityJSON cityJSON = builder.create().fromJson(reader, CityJSON.class);
		if (cityJSON != null) {
			metadata = cityJSON.getMetadata();
			CityModel cityModel = unmarshaller.unmarshal(cityJSON);
			
			if (metadata != null) {
				if (metadata.isSetGeographicalExtent()) {
					List<Double> bbox = metadata.getGeographicalExtent();
					if (bbox.size() > 5) {
						BoundingShape boundedBy = new BoundingShape();
						boundedBy.setEnvelope(new BoundingBox(
								new Point(bbox.get(0), bbox.get(1), bbox.get(2)), 
								new Point(bbox.get(3), bbox.get(4), bbox.get(5))));
						
						if (metadata.isSetReferenceSystem())
							boundedBy.getEnvelope().setSrsName(metadata.getReferenceSystem());
						
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
		builder.registerTypeAdapter(AbstractCityObjectType.class, new CityObjectTypeAdapter().withTypeFilter(filter));
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
