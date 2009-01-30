package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.RailwayType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Railway;

public class RailwayImpl extends TransportationComplexImpl implements Railway {
	private RailwayType railwayType;

	public RailwayImpl() {
		this(new RailwayType());
	}

	public RailwayImpl(RailwayType railwayType) {
		super(railwayType);
		this.railwayType = railwayType;
	}

	@Override
	public RailwayType getJAXBObject() {
		return railwayType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RAILWAY;
	}

	@Override
	public void addGenericApplicationPropertyOfRailway(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			railwayType.get_GenericApplicationPropertyOfRailway().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfRailway() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : railwayType.get_GenericApplicationPropertyOfRailway()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfRailway(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			railwayType.unset_GenericApplicationPropertyOfRailway();
			railwayType.get_GenericApplicationPropertyOfRailway().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfRailway() {
		return railwayType.isSet_GenericApplicationPropertyOfRailway();
	}

	@Override
	public void unsetGenericApplicationPropertyOfRailway() {
		railwayType.unset_GenericApplicationPropertyOfRailway();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfRailway(ADEComponent adeObject) {
		if (railwayType.isSet_GenericApplicationPropertyOfRailway()) {
			Iterator<JAXBElement<?>> iter = railwayType.get_GenericApplicationPropertyOfRailway().iterator();
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
