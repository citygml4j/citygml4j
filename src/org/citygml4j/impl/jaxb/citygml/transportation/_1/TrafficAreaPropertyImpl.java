package org.citygml4j.impl.jaxb.citygml.transportation._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.tran._1.TrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._1.TrafficAreaType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationModule;

public class TrafficAreaPropertyImpl extends AssociationImpl<TrafficArea> implements TrafficAreaProperty {
	private TrafficAreaPropertyType trafficAreaPropertyType;

	public TrafficAreaPropertyImpl() {
		this(new TrafficAreaPropertyType());
	}

	public TrafficAreaPropertyImpl(TrafficAreaPropertyType trafficAreaPropertyType) {
		super(trafficAreaPropertyType);
		this.trafficAreaPropertyType = trafficAreaPropertyType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFICAREAPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return TransportationModule.v1_0_0;
	}

	@Override
	public TrafficAreaPropertyType getJAXBObject() {
		return trafficAreaPropertyType;
	}

	public TrafficArea getObject() {
		if (trafficAreaPropertyType.isSet_Object()) {
			JAXBElement<?> trafficArea = trafficAreaPropertyType.get_Object();
			
			if (trafficArea.getValue() != null) {
				Object elem = trafficArea.getValue();
				QName name = trafficArea.getName();
				
				if (elem instanceof TrafficAreaType)
					return ModelMapper.TRAN_1.toCityGML((TrafficAreaType)elem, name);
			}
		}

		return null;
	}

	public void setObject(TrafficArea object) {
		JAXBElement<?> jaxbElem = ModelMapper.TRAN_1.toJAXB(object);
		trafficAreaPropertyType.set_Object(jaxbElem);
	}

}
