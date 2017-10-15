package org.citygml4j.builder.json.marshal;

import java.util.List;

import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.json.marshal.util.AppearanceResolver;
import org.citygml4j.builder.json.marshal.util.GeometryXlinkResolver;
import org.citygml4j.builder.json.marshal.util.SimpleTextureVerticesBuilder;
import org.citygml4j.builder.json.marshal.util.SimpleVerticesBuilder;
import org.citygml4j.builder.json.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.json.marshal.util.VerticesBuilder;
import org.citygml4j.builder.json.objects.CityJSON;
import org.citygml4j.builder.json.objects.appearance.AppearanceType;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.model.citygml.core.CityModel;

public class CityJSONMarshaller {
	public static final String GEOMETRY_XLINK = "org.citygml4j.geometry.xlink";
	public static final String GEOMETRY_XLINK_TARGET = "org.citygml4j.geometry.xlinkTarget";
	public static final String GEOMETRY_SURFACE_DATA = "org.citygml4j.geometry.surfaceData";

	private final VerticesBuilder verticesBuilder;
	private final TextureVerticesBuilder textureVerticesBuilder;
	private final CityGMLMarshaller citygml;
	private final GMLMarshaller gml;	

	private final GeometryXlinkResolver xlinkResolver;
	private final AppearanceResolver appearanceResolver;
	private String defaultTheme = "";

	public CityJSONMarshaller(VerticesBuilder verticesBuilder, TextureVerticesBuilder textureVerticesBuilder) {
		this.verticesBuilder = verticesBuilder;
		this.textureVerticesBuilder = textureVerticesBuilder;

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this);

		xlinkResolver = new GeometryXlinkResolver();
		appearanceResolver = new AppearanceResolver(defaultTheme, citygml.getAppearanceMarshaller());
	}

	public CityJSONMarshaller() {
		this (new SimpleVerticesBuilder(), new SimpleTextureVerticesBuilder());
	}

	public CityJSON marshal(CityModel src) {
		// preprocess city model
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		CityJSON dest = new CityJSON();
		
		// marshal city model to json
		List<AbstractCityObjectType> cityObjects = citygml.marshal(src);
		if (!cityObjects.isEmpty()) {
			dest.setCityObjects(cityObjects);
			dest.setVertices(verticesBuilder.getVertices());

			if (appearanceResolver.hasTextures() || appearanceResolver.hasMaterials()) {
				AppearanceType appearance = new AppearanceType();
				dest.setAppearance(appearance);

				if (appearanceResolver.hasTextures() && textureVerticesBuilder.getNumTextureVertices() > 0) {
					appearance.setTextures(appearanceResolver.getTextures());
					appearance.setTextureVertices(textureVerticesBuilder.getTextureVertices());
				}

				if (appearanceResolver.hasMaterials())
					appearance.setMaterials(appearanceResolver.getMaterials());			
			}
		}

		return dest;
	}

	public CityGMLMarshaller getCityGMLMarshaller() {
		return citygml;
	}

	public GMLMarshaller getGMLMarshaller() {
		return gml;
	}

	public GeometryXlinkResolver getGeometryXlinkResolver() {
		return xlinkResolver;
	}

	public AppearanceResolver getAppearanceResolver() {
		return appearanceResolver;
	}

	public VerticesBuilder getVertexArrayBuilder() {
		return verticesBuilder;
	}

	public TextureVerticesBuilder getTextureVertexArrayBuilder() {
		return textureVerticesBuilder;
	}

}
