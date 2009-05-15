package org.citygml4j.impl.jaxb.citygml.relief._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.dem._1.AbstractReliefComponentType;
import org.citygml4j.jaxb.citygml.dem._1.BreaklineReliefType;
import org.citygml4j.jaxb.citygml.dem._1.MassPointReliefType;
import org.citygml4j.jaxb.citygml.dem._1.RasterReliefType;
import org.citygml4j.jaxb.citygml.dem._1.ReliefComponentPropertyType;
import org.citygml4j.jaxb.citygml.dem._1.TINReliefType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.citygml.relief.TINRelief;

public class ReliefComponentPropertyImpl extends AssociationImpl<ReliefComponent> implements ReliefComponentProperty {
	private ReliefComponentPropertyType reliefComponentPropertyType;
	
	public ReliefComponentPropertyImpl() {
		this(new ReliefComponentPropertyType());
	}
	
	public ReliefComponentPropertyImpl(ReliefComponentPropertyType reliefComponentPropertyType) {
		super(reliefComponentPropertyType);
		this.reliefComponentPropertyType = reliefComponentPropertyType;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEFCOMPONENTPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return ReliefModule.v1_0_0;
	}

	@Override
	public ReliefComponentPropertyType getJAXBObject() {
		return reliefComponentPropertyType;
	}

	public ReliefComponent getObject() {
		if (reliefComponentPropertyType.isSet_Object()) {
			JAXBElement<?> reliefComponent = reliefComponentPropertyType.get_Object();
			
			if (reliefComponent.getValue() != null) {
				Object elem = reliefComponent.getValue();
				QName name = reliefComponent.getName();
				
				if (elem instanceof TINReliefType)
					return ModelMapper.DEM_1.toCityGML((TINReliefType)elem, name);
				else if (elem instanceof BreaklineReliefType)
					return ModelMapper.DEM_1.toCityGML((BreaklineReliefType)elem, name);
				else if (elem instanceof MassPointReliefType)
					return ModelMapper.DEM_1.toCityGML((MassPointReliefType)elem, name);
				else if (elem instanceof RasterReliefType)
					return ModelMapper.DEM_1.toCityGML((RasterReliefType)elem, name);
				else if (elem instanceof AbstractReliefComponentType)
					return ModelMapper.DEM_1.toCityGML((AbstractReliefComponentType)elem, name);
			}
		}
		
		return null;
	}

	public void setObject(ReliefComponent object) {
		JAXBElement<?> jaxbElem = null;
		
		if (object instanceof TINRelief)
			jaxbElem = ModelMapper.DEM_1.toJAXB((TINRelief)object);
		else if (object instanceof BreaklineRelief)
			jaxbElem = ModelMapper.DEM_1.toJAXB((BreaklineRelief)object);
		else if (object instanceof MassPointRelief)
			jaxbElem = ModelMapper.DEM_1.toJAXB((MassPointRelief)object);
		else if (object instanceof RasterRelief)
			jaxbElem = ModelMapper.DEM_1.toJAXB((RasterRelief)object);
		else if (object instanceof ReliefComponent)
			jaxbElem = ModelMapper.DEM_1.toJAXB((ReliefComponent)object);
		
		if (jaxbElem != null)
			reliefComponentPropertyType.set_Object(jaxbElem);
	}

}
