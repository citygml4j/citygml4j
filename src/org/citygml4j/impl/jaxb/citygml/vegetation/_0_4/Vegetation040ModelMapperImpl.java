package org.citygml4j.impl.jaxb.citygml.vegetation._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.PlantCoverType;
import org.citygml4j.jaxb.citygml._0_4.SolitaryVegetationObjectType;
import org.citygml4j.jaxb.citygml._0_4._VegetationObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationObject;

public class Vegetation040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public PlantCover toCityGML(PlantCoverType plantCover, QName name) {		
		if (plantCover.getClass().equals(PlantCoverType.class))
			return new PlantCoverImpl(plantCover);
		else
			return (PlantCover)jaxb2ade(plantCover, name, PlantCover.class);
	}
	
	public SolitaryVegetationObject toCityGML(SolitaryVegetationObjectType solitaryVegetationObject, QName name) {		
		if (solitaryVegetationObject.getClass().equals(SolitaryVegetationObjectType.class))
			return new SolitaryVegetationObjectImpl(solitaryVegetationObject);
		else
			return (SolitaryVegetationObject)jaxb2ade(solitaryVegetationObject, name, SolitaryVegetationObject.class);
	}
	
	public VegetationObject toCityGML(_VegetationObjectType vegetationObject, QName name) {		
		// we are just checking ADEs
		return (VegetationObject)jaxb2ade(vegetationObject, name, VegetationObject.class);
	}
	
	public JAXBElement<? extends PlantCoverType> toJAXB(PlantCover plantCover) {
		if (!(plantCover instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createPlantCover(((PlantCoverImpl)plantCover).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)plantCover, PlantCoverType.class);
	}
	
	public JAXBElement<? extends SolitaryVegetationObjectType> toJAXB(SolitaryVegetationObject solitaryVegetationObject) {
		if (!(solitaryVegetationObject instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createSolitaryVegetationObject(((SolitaryVegetationObjectImpl)solitaryVegetationObject).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)solitaryVegetationObject, SolitaryVegetationObjectType.class);
	}
	
	public JAXBElement<? extends _VegetationObjectType> toJAXB(VegetationObject vegetationObject) {
		// we are just checking ADEs
		if (vegetationObject instanceof ADEComponent)
			return ade2jaxb((ADEComponent)vegetationObject, _VegetationObjectType.class);
		
		return null;
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof PlantCoverType)
				cityGMLBase = toCityGML((PlantCoverType)value, name);
			else if (value instanceof SolitaryVegetationObjectType)
				cityGMLBase = toCityGML((SolitaryVegetationObjectType)value, name);
			else if (value instanceof _VegetationObjectType)
				cityGMLBase = toCityGML((_VegetationObjectType)value, name);	
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof PlantCover)
			jaxbElem = toJAXB((PlantCover)cityGML);
		else if (cityGML instanceof SolitaryVegetationObject)
			jaxbElem = toJAXB((SolitaryVegetationObject)cityGML);	
		else if (cityGML instanceof VegetationObject)
			jaxbElem = toJAXB((VegetationObject)cityGML);
		
		return jaxbElem;
	}

}
