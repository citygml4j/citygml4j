package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.DoorType;
import org.citygml4j.jaxb.citygml._0_4.OpeningPropertyType;
import org.citygml4j.jaxb.citygml._0_4.WindowType;
import org.citygml4j.jaxb.citygml._0_4._OpeningType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.Window;

public class OpeningPropertyImpl extends AssociationImpl<Opening> implements OpeningProperty {
	private OpeningPropertyType openingPropertyType;

	public OpeningPropertyImpl() {
		this(new OpeningPropertyType());
	}

	public OpeningPropertyImpl(OpeningPropertyType openingPropertyType) {
		super(openingPropertyType);
		this.openingPropertyType = openingPropertyType;
	}

	@Override
	public OpeningPropertyType getJAXBObject() {
		return openingPropertyType;
	}

	@Override
	public Opening getObject() {
		if (openingPropertyType.isSet_Object()) {
			JAXBElement<?> opening = openingPropertyType.get_Object();
			
			if (opening.getValue() != null) {
				Object elem = opening.getValue();
				QName name = opening.getName();
				
				if (elem instanceof DoorType)
					return ModelMapper.BLDG_0_4.toCityGML((DoorType)elem, name);
				else if (elem instanceof WindowType)
					return ModelMapper.BLDG_0_4.toCityGML((WindowType)elem, name);
				else if (elem instanceof _OpeningType)
					return ModelMapper.BLDG_0_4.toCityGML((_OpeningType)elem, name);
			}
		}

		return null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.OPENINGPROPERTY;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public void setObject(Opening object) {
		JAXBElement<?> jaxbElem = null;

		if (object instanceof Window)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((Window)object);
		else if (object instanceof Door)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((Door)object);
		else if (object instanceof Opening)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((Opening)object);

		if (jaxbElem != null)
			openingPropertyType.set_Object(jaxbElem);
	}

}
