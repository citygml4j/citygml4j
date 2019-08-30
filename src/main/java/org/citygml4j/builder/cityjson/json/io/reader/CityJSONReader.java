/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.CityJSONTypeAdapterFactory;
import org.citygml4j.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.cityjson.metadata.MetadataType;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;

import java.io.IOException;

public class CityJSONReader implements AutoCloseable {
	private final JsonReader reader;
	private final GsonBuilder builder;
	private final CityJSONUnmarshaller unmarshaller;
	
	private MetadataType metadata;
	private CityObjectTypeFilter typeFilter;
	private boolean processUnknownExtensions;

	public CityJSONReader(JsonReader reader, CityJSONInputFactory factory) {
		this.reader = reader;
		
		builder = new GsonBuilder();
		unmarshaller = new CityJSONUnmarshaller(factory.textureFileHandler);
		processUnknownExtensions = factory.processUnknownExtensions;
	}

	public CityModel read() throws CityJSONReadException {
		// prepare builder
		builder.registerTypeAdapterFactory(new CityJSONTypeAdapterFactory()
				.withTypeFilter(typeFilter)
				.processUnknownExtensions(processUnknownExtensions));

		CityJSON cityJSON;
		try {
			cityJSON = builder.create().fromJson(reader, CityJSON.class);
		} catch (JsonIOException | JsonSyntaxException e) {
			throw new CityJSONReadException("Caused by: ", e);
		}

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

	void setObjectTypeFilter(CityObjectTypeFilter typeFilter) {
		this.typeFilter = typeFilter;
	}

	void setCityGMLNameFilter(CityGMLInputFilter nameFilter) {
		unmarshaller.setCityGMLNameFilter(nameFilter);
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
