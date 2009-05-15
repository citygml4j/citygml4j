package org.citygml4j.impl.jaxb.citygml.transportation._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.jaxb.citygml.tran._1.AbstractTransportationObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.TransportationModule;
import org.citygml4j.model.citygml.transportation.TransportationObject;

public abstract class TransportationObjectImpl extends CityObjectImpl implements TransportationObject {
	private AbstractTransportationObjectType transportationObjectType;

	public TransportationObjectImpl(AbstractTransportationObjectType transportationObjectType) {
		super(transportationObjectType);
		this.transportationObjectType = transportationObjectType;
	}

	@Override
	public AbstractTransportationObjectType getJAXBObject() {
		return transportationObjectType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSPORTATIONOBJECT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return TransportationModule.v1_0_0;
	}

	public void addGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			transportationObjectType.get_GenericApplicationPropertyOfTransportationObject().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTransportationObject() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : transportationObjectType.get_GenericApplicationPropertyOfTransportationObject()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

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

	public boolean isSetGenericApplicationPropertyOfTransportationObject() {
		return transportationObjectType.isSet_GenericApplicationPropertyOfTransportationObject();
	}

	public void unsetGenericApplicationPropertyOfTransportationObject() {
		transportationObjectType.unset_GenericApplicationPropertyOfTransportationObject();
	}
	
	public boolean unsetGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject) {
		if (transportationObjectType.isSet_GenericApplicationPropertyOfTransportationObject()) {
			Iterator<JAXBElement<?>> iter = transportationObjectType.get_GenericApplicationPropertyOfTransportationObject().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}
	
}
