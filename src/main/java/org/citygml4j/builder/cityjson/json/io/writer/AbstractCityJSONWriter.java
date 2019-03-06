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
package org.citygml4j.builder.cityjson.json.io.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import org.citygml4j.builder.cityjson.extension.CityJSONExtension;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.cityjson.geometry.VerticesList;
import org.citygml4j.cityjson.geometry.VerticesListAdapter;
import org.citygml4j.cityjson.metadata.MetadataType;
import org.citygml4j.model.citygml.ade.binding.ADEContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCityJSONWriter implements AutoCloseable {
	protected final JsonWriter writer;
	protected final CityJSONMarshaller marshaller;
	protected final Gson gson;
	
	protected MetadataType metadata;
	protected Map<String, String> extensions;
	
	public AbstractCityJSONWriter(JsonWriter writer, CityJSONOutputFactory factory) {
		this.writer = writer;
		
		marshaller = new CityJSONMarshaller(factory.verticesBuilder,
				factory.textureVerticesBuilder,
				factory.textureFileHandler,
				factory.templatesVerticesBuilder);
		GsonBuilder builder = new GsonBuilder();
		
		// apply transformation to vertices
		if (factory.verticesTransformer != null) {
			marshaller.setVerticesTransformer(factory.verticesTransformer);
			builder.registerTypeAdapter(VerticesList.class, new VerticesListAdapter().serializeAsInteger(true));
		}
		
		gson = builder.create();
	}

	public MetadataType getMetadata() {
		return metadata;
	}

	public void setMetadata(MetadataType metadata) {
		this.metadata = metadata;
	}

	public void setExtension(String name, String schemaURI) {
		if (extensions == null)
			extensions = new HashMap<>();

		extensions.put(name, schemaURI);
	}

	public void setExtensions(List<ADEContext> adeContexts) {
		for (ADEContext adeContext : adeContexts) {
			if (adeContext instanceof CityJSONExtensionContext) {
				CityJSONExtension extension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
				for (CityJSONExtensionModule module : extension.getExtensionModules()) {
					if (module != null && module.getIdentifier() != null && module.getSchemaURI() != null)
						setExtension(module.getIdentifier(), module.getSchemaURI());
				}
			}
		}
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
	
	public CityJSONMarshaller getCityJSONMarshaller() {
		return marshaller;
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
