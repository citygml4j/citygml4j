package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.RoadType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Road;

public class RoadImpl extends TransportationComplexImpl implements Road {
	private RoadType roadType;

	public RoadImpl() {
		this(new RoadType());
	}

	public RoadImpl(RoadType roadType) {
		super(roadType);
		this.roadType = roadType;
	}

	@Override
	public RoadType getJAXBObject() {
		return roadType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROAD;
	}

	@Override
	public void addGenericApplicationPropertyOfRoad(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			roadType.get_GenericApplicationPropertyOfRoad().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfRoad() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = roadType.get_GenericApplicationPropertyOfRoad();

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
	public void setGenericApplicationPropertyOfRoad(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			roadType.unset_GenericApplicationPropertyOfRoad();
			roadType.get_GenericApplicationPropertyOfRoad().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfRoad() {
		return roadType.isSet_GenericApplicationPropertyOfRoad();
	}

	@Override
	public void unsetGenericApplicationPropertyOfRoad() {
		roadType.unset_GenericApplicationPropertyOfRoad();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfRoad(ADEComponent adeObject) {
		if (roadType.isSet_GenericApplicationPropertyOfRoad()) {
			Iterator<JAXBElement<?>> iter = roadType.get_GenericApplicationPropertyOfRoad().iterator();
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
