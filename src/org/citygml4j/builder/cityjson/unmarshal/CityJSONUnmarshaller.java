package org.citygml4j.builder.cityjson.unmarshal;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.util.SimpleTextureFileHandler;
import org.citygml4j.builder.cityjson.unmarshal.util.TextureFileHandler;
import org.citygml4j.model.citygml.core.CityModel;

public class CityJSONUnmarshaller {
	public static final String SURFACE_DATA_ID = "org.citygml4j.appearance.id";
	public static final String TEXTURE_COORDINATES = "org.citygml4j.textureCoordinates";
	
	private final TextureFileHandler textureFileHandler;
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;
	
	public CityJSONUnmarshaller(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = textureFileHandler != null ? textureFileHandler : new SimpleTextureFileHandler();
		
		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
	}
	
	public CityJSONUnmarshaller() {
		this(new SimpleTextureFileHandler());
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
	
}
