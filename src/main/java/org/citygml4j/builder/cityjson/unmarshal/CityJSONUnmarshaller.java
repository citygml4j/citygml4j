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
package org.citygml4j.builder.cityjson.unmarshal;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.util.DefaultTextureFileHandler;
import org.citygml4j.builder.cityjson.unmarshal.util.TextureFileHandler;
import org.citygml4j.model.citygml.core.CityModel;

import java.util.Objects;

public class CityJSONUnmarshaller {
	public static final String SURFACE_DATA_ID = "org.citygml4j.appearance.id";
	public static final String TEXTURE_COORDINATES = "org.citygml4j.textureCoordinates";
	
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;

	private TextureFileHandler textureFileHandler;

	public CityJSONUnmarshaller(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = textureFileHandler != null ? textureFileHandler : new DefaultTextureFileHandler();
		
		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
	}
	
	public CityJSONUnmarshaller() {
		this(new DefaultTextureFileHandler());
	}

	public CityModel unmarshal(CityJSON src) {
		gml.setVertices(src.getVertices());
		if (src.isSetTransform())
			gml.applyTransformation(src.getTransform());
		
		if (src.isSetAppearance())
			citygml.getAppearanceUnmarshaller().setAppearanceInfo(src.getAppearance());

		return citygml.getCoreUnmarshaller().unmarshalCityModel(src);
	}
	
	public CityGMLUnmarshaller getCityGMLUnmarshaller() {
		return citygml;
	}
	
	public GMLUnmarshaller getGMLUnmarshaller() {
		return gml;
	}

	public TextureFileHandler getTextureFileHandler() {
		return textureFileHandler;
	}
	
	public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = Objects.requireNonNull(textureFileHandler, "texture file handler builder may not be null.");
	}
	
}
