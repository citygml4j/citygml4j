package org.citygml4j.builder.cityjson.unmarshal.citygml.landuse;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.LandUseType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.AbstractSurfaceCollectionType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public class LandUseUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	
	public LandUseUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof LandUseType)
			return unmarshalLandUse((LandUseType)src);

		return null;
	}
	
	public void unmarshalLandUse(LandUseType src, LandUse dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof AbstractSurfaceCollectionType) {
				AbstractSurfaceCollectionType surfaceType = (AbstractSurfaceCollectionType)geometryType;
				MultiSurface multiSurface = json.getGMLUnmarshaller().unmarshalMultiSurface(surfaceType, dest);
				
				if (multiSurface != null) {
					int lod = geometryType.getLod().intValue();
					switch (lod) {
					case 0:
						dest.setLod0MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 1:
						dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 2:
						dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 3:
						dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					}
				}
			}	
		}
	}
	
	public LandUse unmarshalLandUse(LandUseType src) {
		LandUse dest = new LandUse();
		unmarshalLandUse(src, dest);
		
		return dest;
	}
}
