package org.citygml4j.impl.jaxb.citygml.landuse._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.LandUseType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.landuse.LandUse;

public class LandUse040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public LandUse toCityGML(LandUseType landUse, QName name) {		
		if (landUse.getClass().equals(LandUseType.class))
			return new LandUseImpl(landUse);
		else
			return (LandUse)jaxb2ade(landUse, name, LandUse.class);
	}
	
	public JAXBElement<? extends LandUseType> toJAXB(LandUse landUse) {
		if (!(landUse instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createLandUse(((LandUseImpl)landUse).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)landUse, LandUseType.class);
	}
	
	@Override
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof LandUseType)
				cityGMLBase = toCityGML((LandUseType)value, name);		
		}

		return cityGMLBase;
	}

	@Override
	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof LandUse)
			jaxbElem = toJAXB((LandUse)cityGML);	
		
		return jaxbElem;
	}

}
