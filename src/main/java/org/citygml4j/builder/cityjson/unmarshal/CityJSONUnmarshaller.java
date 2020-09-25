/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.ade.ADEUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.cityjson.util.CityGMLMetadata;
import org.citygml4j.builder.cityjson.util.DefaultTextureFileHandler;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.CityJSONRegistry;
import org.citygml4j.cityjson.extension.ExtensionException;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;

import java.util.Objects;

public class CityJSONUnmarshaller {
	public static final String SURFACE_DATA_ID = "org.citygml4j.appearance.id";
	public static final String TEXTURE_COORDINATES = "org.citygml4j.textureCoordinates";
	public static final String GEOMETRY_INSTANCE_LOD = "org.citygml4j.implicitGeometry.lod";

	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;
	private final ADEUnmarshaller ade;
	private final CityJSONRegistry registry;

	private TextureFileHandler textureFileHandler;
	private CityGMLInputFilter nameFilter;
	private boolean releaseCityJSONContent = true;

	public CityJSONUnmarshaller() {
		this.textureFileHandler = new DefaultTextureFileHandler();
		
		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
		ade = new ADEUnmarshaller(this);
		registry = CityJSONRegistry.getInstance();

		try {
			registry.registerExtensionProperty(CityGMLMetadata.JSON_KEY, CityGMLMetadata.class, CityJSON.class);
		} catch (ExtensionException e) {
			//
		}
	}

	public CityModel unmarshal(CityJSON src) {
		prepareUnmarshaller(src);

		CityModel dest = citygml.getCoreUnmarshaller().unmarshalCityModel(src);
		if (dest != null && citygml.getCoreUnmarshaller().hasGlobalAppearances()) {
			for (Appearance appearance : citygml.getCoreUnmarshaller().getGlobalAppearances())
				dest.addAppearanceMember(new AppearanceMember(appearance));
		}

		releaseCityJSONContent(src);
		return dest;
	}

	public void unmarshal(CityJSON src, CityModel stub, CityObjectProcessor processor) throws Exception {
		prepareUnmarshaller(src);

		citygml.getCoreUnmarshaller().unmarshalCityModel(src, stub, processor);
		if (citygml.getCoreUnmarshaller().hasGlobalAppearances()) {
			for (Appearance appearance : citygml.getCoreUnmarshaller().getGlobalAppearances())
				processor.process(appearance);
		}

		releaseCityJSONContent(src);
	}

	private void prepareUnmarshaller(CityJSON src) {
		gml.setVertices(src.getVertices());
		if (src.isSetTransform())
			gml.applyTransformation(src.getTransform());

		if (src.isSetAppearance())
			citygml.getAppearanceUnmarshaller().setAppearanceInfo(src.getAppearance());

		if (src.isSetGeometryTemplates())
			citygml.getCoreUnmarshaller().setGeometryTemplatesInfo(src.getGeometryTemplates());

		if (src.isSetExtensionProperties()) {
			Object metadata = src.getExtensionProperties().get(CityGMLMetadata.JSON_KEY);
			if (metadata instanceof CityGMLMetadata)
				citygml.getGenericsUnmarshaller().setGenericAttributeTypes(((CityGMLMetadata) metadata).getGenericAttributeTypes());
		}
	}

	private void releaseCityJSONContent(CityJSON src) {
		if (releaseCityJSONContent) {
			src.unsetMetadata();
			src.unsetExtensions();
			src.unsetExtensionProperties();
			src.unsetCityObjects();
			src.unsetVertices();
			src.unsetTransform();
			src.unsetGeometryTemplates();
			src.unsetAppearance();
		}
	}
	
	public CityGMLUnmarshaller getCityGMLUnmarshaller() {
		return citygml;
	}
	
	public GMLUnmarshaller getGMLUnmarshaller() {
		return gml;
	}

	public ADEUnmarshaller getADEUnmarshaller() {
		return ade;
	}

	public TextureFileHandler getTextureFileHandler() {
		return textureFileHandler;
	}
	
	public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = Objects.requireNonNull(textureFileHandler, "texture file handler builder may not be null.");
	}

	public boolean isSetCityGMLNameFilter() {
		return nameFilter != null;
	}

	public CityGMLInputFilter getCityGMLNameFilter() {
		return nameFilter;
	}

	public void setCityGMLNameFilter(CityGMLInputFilter nameFilter) {
		this.nameFilter = nameFilter;
	}

	public CityJSONRegistry getCityJSONRegistry() {
		return registry;
	}

	public boolean isReleaseCityJSONContent() {
		return releaseCityJSONContent;
	}

	public void setReleaseCityJSONContent(boolean releaseCityJSONContent) {
		this.releaseCityJSONContent = releaseCityJSONContent;
	}
}
