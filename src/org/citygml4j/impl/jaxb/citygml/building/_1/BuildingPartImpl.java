package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingPart;

public class BuildingPartImpl extends AbstractBuildingImpl implements BuildingPart {
	private BuildingPartType buildingPart;

	public BuildingPartImpl() {
		this(new BuildingPartType());
	}

	public BuildingPartImpl(BuildingPartType buildingPart) {
		super(buildingPart);
		this.buildingPart = buildingPart;
	}

	@Override
	public BuildingPartType getJAXBObject() {
		return buildingPart;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGPART;
	}

	@Override
	public void addGenericApplicationPropertyOfBuildingPart(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			buildingPart.get_GenericApplicationPropertyOfBuildingPart().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfBuildingPart() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = buildingPart.get_GenericApplicationPropertyOfBuildingPart();

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
	public void setGenericApplicationPropertyOfBuildingPart(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			buildingPart.unset_GenericApplicationPropertyOfBuildingPart();
			buildingPart.get_GenericApplicationPropertyOfBuildingPart().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfBuildingPart() {
		return buildingPart.isSet_GenericApplicationPropertyOfBuildingPart();
	}

	@Override
	public void unsetGenericApplicationPropertyOfBuildingPart() {
		buildingPart.unset_GenericApplicationPropertyOfBuildingPart();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfBuildingPart(ADEComponent adeObject) {
		if (buildingPart.isSet_GenericApplicationPropertyOfBuildingPart()) {
			Iterator<JAXBElement<?>> iter = buildingPart.get_GenericApplicationPropertyOfBuildingPart().iterator();
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
