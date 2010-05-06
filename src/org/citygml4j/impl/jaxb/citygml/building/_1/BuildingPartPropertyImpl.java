package org.citygml4j.impl.jaxb.citygml.building._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;

public class BuildingPartPropertyImpl extends AssociationImpl<BuildingPart> implements BuildingPartProperty {
	private BuildingPartPropertyType buildingPartPropertyType;

	public BuildingPartPropertyImpl() {
		this(new BuildingPartPropertyType());
	}

	public BuildingPartPropertyImpl(BuildingPartPropertyType buildingPartPropertyType) {
		super(buildingPartPropertyType);
		this.buildingPartPropertyType = buildingPartPropertyType;
	}

	@Override
	public BuildingPartPropertyType getJAXBObject() {
		return buildingPartPropertyType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGPARTPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	public BuildingPart getObject() {
		if (buildingPartPropertyType.get_Object() != null) {
			JAXBElement<?> buildingPart = buildingPartPropertyType.get_Object();
			
			if (buildingPart.getValue() != null) {
				Object elem = buildingPart.getValue();
				QName name = buildingPart.getName();
				
				if (elem instanceof BuildingPartType)
					return ModelMapper.BLDG_1.toCityGML((BuildingPartType)elem, name);
			}
		}

		return null;
	}

	public void setObject(BuildingPart object) {
		JAXBElement<?> jaxbElem = ModelMapper.BLDG_1.toJAXB(object);
		buildingPartPropertyType.set_Object(jaxbElem);
	}

}
