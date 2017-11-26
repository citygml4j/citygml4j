package org.citygml4j.builder.json.unmarshal;

import org.citygml4j.builder.json.objects.CityJSON;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.builder.json.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.json.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;

public class CityJSONUnmarshaller {
	public static final String SURFACE_DATA_ID = "org.citygml4j.appearance.id";
	public static final String TEXTURE_COORDINATES = "org.citygml4j.textureCoordinates";
	
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller gml;
	
	public CityJSONUnmarshaller() {
		citygml = new CityGMLUnmarshaller(this);
		gml = new GMLUnmarshaller(this);
	}

	public CityModel unmarshal(CityJSON src) {
		CityModel dest = new CityModel();
	
		gml.setVertices(src.getVertices());
		if (src.isSetTransform())
			gml.applyTransformation(src.getTransform());
		
		if (src.isSetAppearance())
			citygml.getAppearanceUnmarshaller().setAppearanceInfo(src.getAppearance());

		for (AbstractCityObjectType cityObjectType : src.getCityObjects()) {
			AbstractCityObject cityObject = citygml.unmarshal(cityObjectType, src);
			if (cityObject != null)
				dest.addCityObjectMember(new CityObjectMember(cityObject));
		}
		
		return dest;
	}
	
	public CityGMLUnmarshaller getCityGMLUnmarshaller() {
		return citygml;
	}
	
	public GMLUnmarshaller getGMLUnmarshaller() {
		return gml;
	}
	
}
