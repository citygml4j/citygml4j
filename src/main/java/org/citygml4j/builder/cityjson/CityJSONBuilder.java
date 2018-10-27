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
package org.citygml4j.builder.cityjson;

import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;

public class CityJSONBuilder {

	public CityJSONUnmarshaller createCityJSONUnmarshaller() {
		return new CityJSONUnmarshaller();
	}
	
	public CityJSONMarshaller createCityJSONMarshaller() {
		return new CityJSONMarshaller();
	}
	
	public CityJSONMarshaller createCityJSONMarshaller(VerticesBuilder verticesBuilder,
													   TextureVerticesBuilder textureVerticesBuilder,
													   TextureFileHandler textureFileHandler,
													   VerticesBuilder templatesVerticesBuilder) {
		return new CityJSONMarshaller(verticesBuilder, textureVerticesBuilder, textureFileHandler, templatesVerticesBuilder);
	}
	
	public CityJSONInputFactory createCityJSONInputFactory() throws CityJSONBuilderException {
		return new CityJSONInputFactory();
	}
	
	public CityJSONOutputFactory createCityJSONOutputFactory() throws CityJSONBuilderException {
		return new CityJSONOutputFactory();
	}
	
}
