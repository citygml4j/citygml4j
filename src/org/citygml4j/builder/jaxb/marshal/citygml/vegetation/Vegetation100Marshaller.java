package org.citygml4j.builder.jaxb.marshal.citygml.vegetation;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.veg._1.AbstractVegetationObjectType;
import org.citygml4j.jaxb.citygml.veg._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.veg._1.PlantCoverType;
import org.citygml4j.jaxb.citygml.veg._1.SolitaryVegetationObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationModuleComponent;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;

public class Vegetation100Marshaller {
	private final ObjectFactory veg = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Vegetation100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof VegetationModuleComponent)
			src = marshal(src);
		
		if (src instanceof PlantCoverType)
			dest = veg.createPlantCover((PlantCoverType)src);
		else if (src instanceof SolitaryVegetationObjectType)
			dest = veg.createSolitaryVegetationObject((SolitaryVegetationObjectType)src);
		
		return dest;
	}
	
	public Object marshal(Object src) {
		Object dest = null;
		
		if (src instanceof PlantCover)
			dest = marshalPlantCover((PlantCover)src);
		else if (src instanceof SolitaryVegetationObject)
			dest = marshalSolitaryVegetationObject((SolitaryVegetationObject)src);
		
		return dest;
	}
	
	public void marshalVegetationObject(AbstractVegetationObject src, AbstractVegetationObjectType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfVegetationObject())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfVegetationObject().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public void marshalPlantCover(PlantCover src, PlantCoverType dest) {
		marshalVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetAverageHeight())
			dest.setAverageHeight(jaxb.getGMLMarshaller().marshalLength(src.getAverageHeight()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod1MultiSolid())
			dest.setLod1MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod1MultiSolid()));

		if (src.isSetLod2MultiSolid())
			dest.setLod2MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod2MultiSolid()));

		if (src.isSetLod3MultiSolid())
			dest.setLod3MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod3MultiSolid()));
		
		if (src.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfPlantCover())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfPlantCover().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public PlantCoverType marshalPlantCover(PlantCover src) {
		PlantCoverType dest = veg.createPlantCoverType();
		marshalPlantCover(src, dest);

		return dest;
	}
	
	public void marshalSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObjectType dest) {
		marshalVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetSpecies())
			dest.setSpecies(src.getSpecies());

		if (src.isSetHeight())
			dest.setHeight(jaxb.getGMLMarshaller().marshalLength(src.getHeight()));

		if (src.isSetTrunkDiameter())
			dest.setTrunkDiameter(jaxb.getGMLMarshaller().marshalLength(src.getTrunkDiameter()));

		if (src.isSetCrownDiameter())
			dest.setCrownDiameter(jaxb.getGMLMarshaller().marshalLength(src.getCrownDiameter()));

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
		
		if (src.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfSolitaryVegetationObject())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfSolitaryVegetationObject().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public SolitaryVegetationObjectType marshalSolitaryVegetationObject(SolitaryVegetationObject src) {
		SolitaryVegetationObjectType dest = veg.createSolitaryVegetationObjectType();
		marshalSolitaryVegetationObject(src, dest);

		return dest;
	}
	
}
