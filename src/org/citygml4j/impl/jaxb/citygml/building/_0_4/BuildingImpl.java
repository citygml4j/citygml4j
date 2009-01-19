package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.BuildingType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.Building;

public class BuildingImpl extends AbstractBuildingImpl implements Building {
	private BuildingType buildingType;

	public BuildingImpl() {
		this(new BuildingType());
	}

	public BuildingImpl(BuildingType buildingType) {
		super(buildingType);
		this.buildingType = buildingType;
	}

	@Override
	public BuildingType getJAXBObject() {
		return buildingType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING;
	}

	@Override
	public void addGenericApplicationPropertyOfBuilding(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			buildingType.get_GenericApplicationPropertyOfBuilding().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfBuilding() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : buildingType.get_GenericApplicationPropertyOfBuilding()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfBuilding(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			buildingType.unset_GenericApplicationPropertyOfBuilding();
			buildingType.get_GenericApplicationPropertyOfBuilding().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfBuilding() {
		return buildingType.isSet_GenericApplicationPropertyOfBuilding();
	}

	@Override
	public void unsetGenericApplicationPropertyOfBuilding() {
		buildingType.unset_GenericApplicationPropertyOfBuilding();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfBuilding(ADEComponent adeObject) {
		if (buildingType.isSet_GenericApplicationPropertyOfBuilding()) {
			Iterator<JAXBElement<?>> iter = buildingType.get_GenericApplicationPropertyOfBuilding().iterator();
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
