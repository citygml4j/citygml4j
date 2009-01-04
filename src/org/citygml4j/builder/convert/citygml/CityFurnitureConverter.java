package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.GeometryProperty;

public class CityFurnitureConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected CityFurnitureConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected CityFurniture convertCityFurniture(CityFurniture src) {
		CityFurniture dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof CityFurniture)
				dest = (CityFurniture)tmp;
		} else {
			dest = citygml.createCityFurniture(builder.convertContext.frnModule);
			if (dest != null)
				convertCityFurniture(src, dest);
		}

		return dest;
	}

	protected void convertCityFurniture(CityFurniture src, CityFurniture dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetLod1Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod1Geometry());
			if (tmp != null)
				dest.setLod1Geometry(tmp);
		}

		if (src.isSetLod2Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod2Geometry());
			if (tmp != null)
				dest.setLod2Geometry(tmp);
		}

		if (src.isSetLod3Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod3Geometry());
			if (tmp != null)
				dest.setLod3Geometry(tmp);
		}

		if (src.isSetLod4Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod4Geometry());
			if (tmp != null)
				dest.setLod4Geometry(tmp);
		}

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(src.getLod1TerrainIntersection());

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(src.getLod2TerrainIntersection());

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(src.getLod3TerrainIntersection());

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(src.getLod4TerrainIntersection());

		if (src.isSetLod1ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod1ImplicitRepresentation());
			if (tmp != null)
				dest.setLod1ImplicitRepresentation(tmp);
		}

		if (src.isSetLod2ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (tmp != null)
				dest.setLod2ImplicitRepresentation(tmp);
		}

		if (src.isSetLod3ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (tmp != null)
				dest.setLod3ImplicitRepresentation(tmp);
		}

		if (src.isSetLod4ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod4ImplicitRepresentation());
			if (tmp != null)
				dest.setLod4ImplicitRepresentation(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfCityFurniture()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfCityFurniture(tmp);
			}
		}
	}
}
