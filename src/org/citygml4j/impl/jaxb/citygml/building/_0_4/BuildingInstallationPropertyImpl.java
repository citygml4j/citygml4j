package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingModule;

public class BuildingInstallationPropertyImpl extends AssociationImpl<BuildingInstallation> implements BuildingInstallationProperty {
	private BuildingInstallationPropertyType buildingInstallationPropertyType;

	public BuildingInstallationPropertyImpl() {
		this(new BuildingInstallationPropertyType());
	}

	public BuildingInstallationPropertyImpl(BuildingInstallationPropertyType buildingInstallationPropertyType) {
		super(buildingInstallationPropertyType);
		this.buildingInstallationPropertyType = buildingInstallationPropertyType;
	}

	@Override
	public BuildingInstallationPropertyType getJAXBObject() {
		return buildingInstallationPropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGINSTALLATIONPROPERTY;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public BuildingInstallation getObject() {
		if (buildingInstallationPropertyType.isSet_Object()) {
			JAXBElement<?> buildingInstallation = buildingInstallationPropertyType.get_Object();
			
			if (buildingInstallation.getValue() != null) {
				Object elem = buildingInstallation.getValue();
				QName name = buildingInstallation.getName();
				
				if (elem instanceof BuildingInstallationType)
					return ModelMapper.BLDG_0_4.toCityGML((BuildingInstallationType)elem, name);
			}
		}

		return null;
	}

	@Override
	public void setObject(BuildingInstallation object) {
		JAXBElement<?> jaxbElem = ModelMapper.BLDG_0_4.toJAXB(object);
		buildingInstallationPropertyType.set_Object(jaxbElem);
	}
	
}
