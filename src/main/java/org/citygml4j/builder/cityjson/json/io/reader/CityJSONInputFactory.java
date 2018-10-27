/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import com.google.gson.stream.JsonReader;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class CityJSONInputFactory {
	protected TextureFileHandler textureFileHandler;
	
	public CityJSONReader createCityJSONReader(File file) throws CityJSONReadException {
		try {
			return new CityJSONReader(new JsonReader(new BufferedReader(new FileReader(file))), this);
		} catch (FileNotFoundException e) {
			throw new CityJSONReadException("Caused by: ", e);
		}
	}

	public CityJSONReader createCityJSONReader(InputStream inputStream) throws CityJSONReadException {
		return new CityJSONReader(new JsonReader(new InputStreamReader(inputStream)), this);
	}
	
	public CityJSONReader createFilteredCityJSONReader(CityJSONReader reader, CityObjectTypeFilter filter) throws CityJSONReadException {
		reader.setInputFilter(filter);
		return reader;
	}
	
	public TextureFileHandler getTextureFileHandler() {
		return textureFileHandler;
	}
	
	public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = Objects.requireNonNull(textureFileHandler, "texture file handler builder may not be null.");
	}

}
