package org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.frn._1.CityFurnitureType;
import org.citygml4j.jaxb.citygml.frn._1.ObjectFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModuleComponent;

public class CityFurniture100Marshaller {
	private final ObjectFactory frn = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public CityFurniture100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof CityFurnitureModuleComponent)
			src = marshal(src);
		
		if (src instanceof CityFurnitureType)
			dest = frn.createCityFurniture((CityFurnitureType)src);
		
		return dest;
	}
	
	public Object marshal(Object src) {
		Object dest = null;
		
		if (src instanceof CityFurniture)
			dest = marshalCityFurniture((CityFurniture)src);
		
		return dest;
	}
	
	public void marshalCityFurniture(CityFurniture src, CityFurnitureType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4TerrainIntersection()));
	
		if (src.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCityFurniture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCityFurniture().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public CityFurnitureType marshalCityFurniture(CityFurniture src) {
		CityFurnitureType dest = frn.createCityFurnitureType();
		marshalCityFurniture(src, dest);

		return dest;
	}
	
}
