package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;

public class IntBuildingInstallationPropertyImpl extends AssociationImpl<IntBuildingInstallation> implements IntBuildingInstallationProperty {
	private IntBuildingInstallationPropertyType intBuildingInstallationPropertyType;

	public IntBuildingInstallationPropertyImpl() {
		this(new IntBuildingInstallationPropertyType());
	}

	public IntBuildingInstallationPropertyImpl(IntBuildingInstallationPropertyType intBuildingInstallationPropertyType) {
		super(intBuildingInstallationPropertyType);
		this.intBuildingInstallationPropertyType = intBuildingInstallationPropertyType;
	}

	@Override
	public IntBuildingInstallationPropertyType getJAXBObject() {
		return intBuildingInstallationPropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTBUILDINGINSTALLATIONPROPERTY;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public IntBuildingInstallation getObject() {
		if (intBuildingInstallationPropertyType.isSet_Object()) {
			JAXBElement<?> intBuildingInstallation = intBuildingInstallationPropertyType.get_Object();
			
			if (intBuildingInstallation.getValue() != null) {
				Object elem = intBuildingInstallation.getValue();
				QName name = intBuildingInstallation.getName();
				
				if (elem instanceof IntBuildingInstallationType)
					return ModelMapper.BLDG_0_4.toCityGML((IntBuildingInstallationType)elem, name);
			}
		}

		return null;
	}

	@Override
	public void setObject(IntBuildingInstallation object) {
		JAXBElement<?> jaxbElem = ModelMapper.BLDG_0_4.toJAXB(object);
		intBuildingInstallationPropertyType.set_Object(jaxbElem);
	}

}
