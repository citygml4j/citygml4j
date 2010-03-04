package org.citygml4j.builder.jaxb.marshal.citygml.landuse;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml._0_4.LandUseType;
import org.citygml4j.jaxb.citygml._0_4.ObjectFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.landuse.LandUseModuleComponent;

public class LandUse040Marshaller {
	private final ObjectFactory luse;
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public LandUse040Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();

		luse = citygml.getCore040Marshaller().getObjectFactory();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof LandUseModuleComponent)
			src = marshal(src);

		if (src instanceof LandUseType)
			dest = luse.createLandUse((LandUseType)src);

		return dest;
	}

	public Object marshal(Object src) {
		Object dest = null;

		if (src instanceof LandUse)
			dest = marshalLandUse((LandUse)src);

		return dest;
	}

	public void marshalLandUse(LandUse src, LandUseType dest) {
		citygml.getCore040Marshaller().marshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod0MultiSurface()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfLandUse())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfLandUse().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public LandUseType marshalLandUse(LandUse src) {
		LandUseType dest = luse.createLandUseType();
		marshalLandUse(src, dest);

		return dest;
	}

}
