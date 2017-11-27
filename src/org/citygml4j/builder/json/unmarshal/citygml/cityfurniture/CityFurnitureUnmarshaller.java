package org.citygml4j.builder.json.unmarshal.citygml.cityfurniture;

import org.citygml4j.binding.json.CityJSON;
import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.Attributes;
import org.citygml4j.binding.json.feature.CityFurnitureType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class CityFurnitureUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	
	public CityFurnitureUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof CityFurnitureType)
			return unmarshalCityFurniture((CityFurnitureType)src);

		return null;
	}
	
	public void unmarshalCityFurniture(CityFurnitureType src, CityFurniture dest) {
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
			AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryType, dest);

			if (geometry != null) {
				int lod = geometryType.getLod().intValue();
				switch (lod) {
				case 1:
					dest.setLod1Geometry(new GeometryProperty<>(geometry));
					break;
				case 2:
					dest.setLod2Geometry(new GeometryProperty<>(geometry));
					break;
				case 3:
					dest.setLod3Geometry(new GeometryProperty<>(geometry));
					break;
				}
			}	
		}
	}
	
	public CityFurniture unmarshalCityFurniture(CityFurnitureType src) {
		CityFurniture dest = new CityFurniture();
		unmarshalCityFurniture(src, dest);
		
		return dest;
	}
	
}
