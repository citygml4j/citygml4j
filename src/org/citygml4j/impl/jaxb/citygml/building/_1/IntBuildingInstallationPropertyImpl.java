package org.citygml4j.impl.jaxb.citygml.building._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationType;
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

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTBUILDINGINSTALLATIONPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	public IntBuildingInstallation getObject() {
		if (intBuildingInstallationPropertyType.isSet_Object()) {
			JAXBElement<?> inBuildingInstallation = intBuildingInstallationPropertyType.get_Object();
			
			if (inBuildingInstallation.getValue() != null) {
				Object elem = inBuildingInstallation.getValue();
				QName name = inBuildingInstallation.getName();
				
				if (elem instanceof IntBuildingInstallationType)
					return ModelMapper.BLDG_1.toCityGML((IntBuildingInstallationType)elem, name);
			}
		}

		return null;
	}

	public void setObject(IntBuildingInstallation object) {
		JAXBElement<?> jaxbElem = ModelMapper.BLDG_1.toJAXB(object);
		intBuildingInstallationPropertyType.set_Object(jaxbElem);
	}

}
