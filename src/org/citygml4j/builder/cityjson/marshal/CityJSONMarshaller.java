package org.citygml4j.builder.cityjson.marshal;

import java.util.List;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.appearance.AppearanceType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.AppearanceResolver;
import org.citygml4j.builder.cityjson.marshal.util.GeometryXlinkResolver;
import org.citygml4j.builder.cityjson.marshal.util.SimpleTextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.SimpleVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.model.citygml.core.AbstractCityObject;
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
		this.verticesBuilder = verticesBuilder != null ? verticesBuilder : new SimpleVerticesBuilder();
		this.textureVerticesBuilder = textureVerticesBuilder != null ? textureVerticesBuilder : new SimpleTextureVerticesBuilder();

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this);

		xlinkResolver = new GeometryXlinkResolver();
		appearanceResolver = new AppearanceResolver(defaultTheme, citygml.getAppearanceMarshaller());
	}

	public CityJSONMarshaller() {
		this (new SimpleVerticesBuilder(), new SimpleTextureVerticesBuilder());
	}
	
	public CityJSON marshal(CityModel src) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		CityJSON dest = new CityJSON();

		List<AbstractCityObjectType> cityObjects = citygml.marshal(src);
		if (!cityObjects.isEmpty()) {
			dest.setCityObjects(cityObjects);
			dest.setVertices(verticesBuilder.build());

			if (appearanceResolver.hasTextures() || appearanceResolver.hasMaterials()) {
				AppearanceType appearance = new AppearanceType();
				dest.setAppearance(appearance);

				if (appearanceResolver.hasMaterials())
					appearance.setMaterials(appearanceResolver.getMaterials());			

				if (appearanceResolver.hasTextures()) {
					List<List<Double>> textureVertices = textureVerticesBuilder.build();
					if (textureVertices.size() > 0) {
						appearance.setTextures(appearanceResolver.getTextures());
						appearance.setTextureVertices(textureVertices);
					}
				}
			}
		}

		return dest;
	}
	
	public List<AbstractCityObjectType> marshal(AbstractCityObject src) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		return citygml.marshal(src);
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

	public VerticesBuilder getVerticesBuilder() {
		return verticesBuilder;
	}

	public TextureVerticesBuilder getTextureVerticesBuilder() {
		return textureVerticesBuilder;
	}

}
