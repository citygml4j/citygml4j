package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericDateAttribute;
import org.citygml4j.model.citygml.generics.GenericDoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericIntAttribute;
import org.citygml4j.model.citygml.generics.GenericStringAttribute;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;
import org.citygml4j.model.gml.GeometryProperty;

public class GenericsConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected GenericsConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected GenericCityObject convertGenericCityObject(GenericCityObject src) {
		GenericCityObject dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof GenericCityObject)
				dest = (GenericCityObject)tmp;
		} else {
			dest = citygml.createGenericCityObject(builder.convertContext.genModule);
			if (dest != null)
				convertGenericCityobject(src, dest);
		}

		return dest;
	}

	protected GenericDateAttribute convertGenericDateAttribute(GenericDateAttribute src) {
		GenericDateAttribute dest = citygml.createGenericDateAttribute(builder.convertContext.genModule);
		if (dest != null) {
			convertGenericAttribute(src, dest);

			if (src.isSetValue())
				dest.setValue(src.getValue());
		}

		return dest;
	}

	protected GenericDoubleAttribute convertGenericDoubleAttribute(GenericDoubleAttribute src) {
		GenericDoubleAttribute dest = citygml.createGenericDoubleAttribute(builder.convertContext.genModule);
		if (dest != null) {
			convertGenericAttribute(src, dest);

			if (src.isSetValue())
				dest.setValue(src.getValue());
		}

		return dest;
	}

	protected GenericIntAttribute convertGenericIntAttribute(GenericIntAttribute src) {
		GenericIntAttribute dest = citygml.createGenericIntAttribute(builder.convertContext.genModule);
		if (dest != null) {
			convertGenericAttribute(src, dest);

			if (src.isSetValue())
				dest.setValue(src.getValue());
		}

		return dest;
	}

	protected GenericStringAttribute convertGenericStringAttribute(GenericStringAttribute src) {
		GenericStringAttribute dest = citygml.createGenericStringAttribute(builder.convertContext.genModule);
		if (dest != null) {
			convertGenericAttribute(src, dest);

			if (src.isSetValue())
				dest.setValue(src.getValue());
		}

		return dest;
	}

	protected GenericUriAttribute convertGenericUriAttribute(GenericUriAttribute src) {
		GenericUriAttribute dest = citygml.createGenericUriAttribute(builder.convertContext.genModule);
		if (dest != null) {
			convertGenericAttribute(src, dest);

			if (src.isSetValue())
				dest.setValue(src.getValue());
		}

		return dest;
	}

	protected void convertGenericAttribute(GenericAttribute src, GenericAttribute dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}

	protected void convertGenericCityobject(GenericCityObject src, GenericCityObject dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod0Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod0Geometry());
			if (tmp != null)
				dest.setLod0Geometry(tmp);
		}

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

		if (src.isSetLod0TerrainIntersection())
			dest.setLod0TerrainIntersection(src.getLod0TerrainIntersection());

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(src.getLod1TerrainIntersection());

		if (src.isSetLod2TerainIntersection())
			dest.setLod2TerrainIntersection(src.getLod2TerrainIntersection());

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(src.getLod3TerrainIntersection());

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(src.getLod4TerrainIntersection());

		if (src.isSetLod0ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod0ImplicitRepresentation());
			if (tmp != null)
				dest.setLod0ImplicitRepresentation(tmp);
		}

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
	}
}
