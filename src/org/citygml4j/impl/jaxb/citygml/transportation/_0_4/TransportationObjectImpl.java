package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.jaxb.citygml._0_4._TransportationObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.TransportationModule;
import org.citygml4j.model.citygml.transportation.TransportationObject;

public abstract class TransportationObjectImpl extends CityObjectImpl implements TransportationObject {
	private _TransportationObjectType transportationObjectType;

	public TransportationObjectImpl(_TransportationObjectType transportationObjectType) {
		super(transportationObjectType);
		this.transportationObjectType = transportationObjectType;
	}

	@Override
	public _TransportationObjectType getJAXBObject() {
		return transportationObjectType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSPORTATIONOBJECT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return TransportationModule.v0_4_0;
	}

	@Override
	public void addGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			transportationObjectType.get_GenericApplicationPropertyOfTransportationObject().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTransportationObject() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = transportationObjectType.get_GenericApplicationPropertyOfTransportationObject();

		for (JAXBElement<?> elem : elemList) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfTransportationObject(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			transportationObjectType.unset_GenericApplicationPropertyOfTransportationObject();
			transportationObjectType.get_GenericApplicationPropertyOfTransportationObject().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTransportationObject() {
		return transportationObjectType.isSet_GenericApplicationPropertyOfTransportationObject();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTransportationObject() {
		transportationObjectType.unset_GenericApplicationPropertyOfTransportationObject();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject) {
		if (transportationObjectType.isSet_GenericApplicationPropertyOfTransportationObject()) {
			Iterator<JAXBElement<?>> iter = transportationObjectType.get_GenericApplicationPropertyOfTransportationObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

}
