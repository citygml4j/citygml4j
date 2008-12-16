package org.citygml4j.impl.jaxb.citygml.core._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.citygml.core._1.AbstractSiteType;
import org.citygml4j.jaxb.citygml.core._1.AddressType;
import org.citygml4j.jaxb.citygml.core._1.CityModelType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.Site;

public class Core100ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public Address toCityGML(AddressType address, QName name) {		
		if (address.getClass().equals(AddressType.class))
			return new AddressImpl(address);
		else
			return (Address)jaxb2ade(address, name, Address.class);
	}
	
	public CityModel toCityGML(CityModelType cityModel, QName name) {		
		if (cityModel.getClass().equals(CityModelType.class))
			return new CityModelImpl(cityModel);
		else
			return (CityModel)jaxb2ade(cityModel, name, CityModel.class);
	}
		
	public Site toCityGML(AbstractSiteType site, QName name) {		
		// we are just checking ADEs
		return (Site)jaxb2ade(site, name, Site.class);
	}
	
	public CityObject toCityGML(AbstractCityObjectType cityObject, QName name) {		
		// we are just checking ADEs
		return (CityObject)jaxb2ade(cityObject, name, CityObject.class);
	}
	
	public JAXBElement<? extends AddressType> toJAXB(Address address) {
		if (!(address instanceof ADEComponent))
			return ObjectFactory.CORE_1.createAddress(((AddressImpl)address).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)address, AddressType.class);
	}
	
	public JAXBElement<? extends CityModelType> toJAXB(CityModel cityModel) {
		if (!(cityModel instanceof ADEComponent))
			return ObjectFactory.CORE_1.createCityModel(((CityModelImpl)cityModel).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)cityModel, CityModelType.class);
	}
	
	public JAXBElement<? extends AbstractSiteType> toJAXB(Site site) {
		// we are just checking ADEs
		if (site instanceof ADEComponent)
			return ade2jaxb((ADEComponent)site, AbstractSiteType.class);
		
		return null;
	}
	
	public JAXBElement<? extends AbstractCityObjectType> toJAXB(CityObject cityObject) {
		// we are just checking ADEs
		if (cityObject instanceof ADEComponent)
			return ade2jaxb((ADEComponent)cityObject, AbstractCityObjectType.class);
		
		return null;
	}
	
	@Override
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof AddressType)
				cityGMLBase = toCityGML((AddressType)value, name);
			else if (value instanceof CityModelType)
				cityGMLBase = toCityGML((CityModelType)value, name);
			else if (value instanceof AbstractSiteType)
				cityGMLBase = toCityGML((AbstractSiteType)value, name);
			else if (value instanceof AbstractCityObjectType)
				cityGMLBase = toCityGML((AbstractCityObjectType)value, name);
		}

		return cityGMLBase;
	}

	@Override
	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof Address)
			jaxbElem = toJAXB((Address)cityGML);
		else if (cityGML instanceof CityModel)
			jaxbElem = toJAXB((CityModel)cityGML);
		else if (cityGML instanceof Site)
			jaxbElem = toJAXB((Site)cityGML);
		else if (cityGML instanceof CityObject)
			jaxbElem = toJAXB((CityObject)cityGML);
		
		return jaxbElem;
	}

}
