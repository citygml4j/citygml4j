package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationModule;

public class AuxiliaryTrafficAreaPropertyImpl extends AssociationImpl<AuxiliaryTrafficArea> implements AuxiliaryTrafficAreaProperty {
	private AuxiliaryTrafficAreaPropertyType auxiliaryTrafficAreaPropertyType;

	public AuxiliaryTrafficAreaPropertyImpl() {
		this(new AuxiliaryTrafficAreaPropertyType());
	}

	public AuxiliaryTrafficAreaPropertyImpl(AuxiliaryTrafficAreaPropertyType auxiliaryTrafficAreaPropertyType) {
		super(auxiliaryTrafficAreaPropertyType);
		this.auxiliaryTrafficAreaPropertyType = auxiliaryTrafficAreaPropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.AUXILIARYTRAFFICAREAPROPERTY;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return TransportationModule.v0_4_0;
	}
	
	@Override
	public AuxiliaryTrafficAreaPropertyType getJAXBObject() {
		return auxiliaryTrafficAreaPropertyType;
	}

	@Override
	public AuxiliaryTrafficArea getObject() {
		if (auxiliaryTrafficAreaPropertyType.isSet_Object()) {
			JAXBElement<?> auxiliaryTrafficArea = auxiliaryTrafficAreaPropertyType.get_Object();
			
			if (auxiliaryTrafficArea.getValue() != null) {
				Object elem = auxiliaryTrafficArea.getValue();
				QName name = auxiliaryTrafficArea.getName();
				
				if (elem instanceof AuxiliaryTrafficAreaType)
					return ModelMapper.TRAN_0_4.toCityGML((AuxiliaryTrafficAreaType)elem, name);
			}
		}

		return null;
	}

	@Override
	public void setObject(AuxiliaryTrafficArea object) {
		JAXBElement<?> jaxbElem = ModelMapper.TRAN_0_4.toJAXB(object);
		auxiliaryTrafficAreaPropertyType.set_Object(jaxbElem);
	}

}
