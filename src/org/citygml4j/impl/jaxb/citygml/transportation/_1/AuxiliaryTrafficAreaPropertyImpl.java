package org.citygml4j.impl.jaxb.citygml.transportation._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.tran._1.AuxiliaryTrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._1.AuxiliaryTrafficAreaType;
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

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.AUXILIARYTRAFFICAREAPROPERTY;
	}

	public final CityGMLModule getCityGMLModule() {
		return TransportationModule.v1_0_0;
	}
	
	@Override
	public AuxiliaryTrafficAreaPropertyType getJAXBObject() {
		return auxiliaryTrafficAreaPropertyType;
	}

	public AuxiliaryTrafficArea getObject() {
		if (auxiliaryTrafficAreaPropertyType.isSet_Object()) {
			JAXBElement<?> auxiliaryTrafficArea = auxiliaryTrafficAreaPropertyType.get_Object();
			
			if (auxiliaryTrafficArea.getValue() != null) {
				Object elem = auxiliaryTrafficArea.getValue();
				QName name = auxiliaryTrafficArea.getName();
				
				if (elem instanceof AuxiliaryTrafficAreaType)
					return ModelMapper.TRAN_1.toCityGML((AuxiliaryTrafficAreaType)elem, name);
			}
		}

		return null;
	}

	public void setObject(AuxiliaryTrafficArea object) {
		JAXBElement<?> jaxbElem = ModelMapper.TRAN_1.toJAXB(object);
		auxiliaryTrafficAreaPropertyType.set_Object(jaxbElem);
	}

}
