package org.citygml4j.impl.jaxb.citygml.relief._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.BreaklineReliefType;
import org.citygml4j.jaxb.citygml._0_4.MassPointReliefType;
import org.citygml4j.jaxb.citygml._0_4.RasterReliefType;
import org.citygml4j.jaxb.citygml._0_4.ReliefFeatureType;
import org.citygml4j.jaxb.citygml._0_4.TINReliefType;
import org.citygml4j.jaxb.citygml._0_4._ReliefComponentType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;

public class Relief040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public ReliefFeature toCityGML(ReliefFeatureType reliefFeature, QName name) {		
		if (reliefFeature.getClass().equals(ReliefFeatureType.class))
			return new ReliefFeatureImpl(reliefFeature);
		else
			return (ReliefFeature)jaxb2ade(reliefFeature, name, ReliefFeature.class);
	}
	
	public BreaklineRelief toCityGML(BreaklineReliefType breaklineRelief, QName name) {		
		if (breaklineRelief.getClass().equals(BreaklineReliefType.class))
			return new BreaklineReliefImpl(breaklineRelief);
		else
			return (BreaklineRelief)jaxb2ade(breaklineRelief, name, BreaklineRelief.class);
	}
	
	public RasterRelief toCityGML(RasterReliefType rasterRelief, QName name) {		
		if (rasterRelief.getClass().equals(RasterReliefType.class))
			return new RasterReliefImpl(rasterRelief);
		else
			return (RasterRelief)jaxb2ade(rasterRelief, name, RasterRelief.class);
	}
	
	public MassPointRelief toCityGML(MassPointReliefType massPointRelief, QName name) {		
		if (massPointRelief.getClass().equals(MassPointReliefType.class))
			return new MassPointReliefImpl(massPointRelief);
		else
			return (MassPointRelief)jaxb2ade(massPointRelief, name, MassPointRelief.class);
	}
	
	public TINRelief toCityGML(TINReliefType tinRelief, QName name) {		
		if (tinRelief.getClass().equals(TINReliefType.class))
			return new TINReliefImpl(tinRelief);
		else
			return (TINRelief)jaxb2ade(tinRelief, name, TINRelief.class);
	}
	
	public ReliefComponent toCityGML(_ReliefComponentType reliefComponent, QName name) {		
		// we are just checking ADEs
		return (ReliefComponent)jaxb2ade(reliefComponent, name, ReliefComponent.class);
	}
	
	public JAXBElement<? extends ReliefFeatureType> toJAXB(ReliefFeature reliefFeature) {
		if (!(reliefFeature instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createReliefFeature(((ReliefFeatureImpl)reliefFeature).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)reliefFeature, ReliefFeatureType.class);
	}
	
	public JAXBElement<? extends BreaklineReliefType> toJAXB(BreaklineRelief breaklineRelief) {
		if (!(breaklineRelief instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createBreaklineRelief(((BreaklineReliefImpl)breaklineRelief).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)breaklineRelief, BreaklineReliefType.class);
	}
	
	public JAXBElement<? extends RasterReliefType> toJAXB(RasterRelief rasterRelief) {
		if (!(rasterRelief instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createRasterRelief(((RasterReliefImpl)rasterRelief).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)rasterRelief, RasterReliefType.class);
	}
	
	public JAXBElement<? extends MassPointReliefType> toJAXB(MassPointRelief massPointRelief) {
		if (!(massPointRelief instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createMassPointRelief(((MassPointReliefImpl)massPointRelief).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)massPointRelief, MassPointReliefType.class);
	}
	
	public JAXBElement<? extends TINReliefType> toJAXB(TINRelief tinRelief) {
		if (!(tinRelief instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createTINRelief(((TINReliefImpl)tinRelief).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)tinRelief, TINReliefType.class);
	}
	
	public JAXBElement<? extends _ReliefComponentType> toJAXB(ReliefComponent reliefComponent) {
		// we are just checking ADEs
		if (reliefComponent instanceof ADEComponent)
			return ade2jaxb((ADEComponent)reliefComponent, _ReliefComponentType.class);
		
		return null;
	}
	
	@Override
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof ReliefFeatureType)
				cityGMLBase = toCityGML((ReliefFeatureType)value, name);
			else if (value instanceof BreaklineReliefType)
				cityGMLBase = toCityGML((BreaklineReliefType)value, name);
			else if (value instanceof RasterReliefType)
				cityGMLBase = toCityGML((RasterReliefType)value, name);
			else if (value instanceof MassPointReliefType)
				cityGMLBase = toCityGML((MassPointReliefType)value, name);	
			else if (value instanceof TINReliefType)
				cityGMLBase = toCityGML((TINReliefType)value, name);	
			else if (value instanceof _ReliefComponentType)
				cityGMLBase = toCityGML((_ReliefComponentType)value, name);
		}

		return cityGMLBase;
	}

	@Override
	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof ReliefFeature)
			jaxbElem = toJAXB((ReliefFeature)cityGML);
		else if (cityGML instanceof BreaklineRelief)
			jaxbElem = toJAXB((BreaklineRelief)cityGML);
		else if (cityGML instanceof RasterRelief)
			jaxbElem = toJAXB((RasterRelief)cityGML);
		else if (cityGML instanceof MassPointRelief)
			jaxbElem = toJAXB((MassPointRelief)cityGML);	
		else if (cityGML instanceof TINRelief)
			jaxbElem = toJAXB((TINRelief)cityGML);
		else if (cityGML instanceof ReliefComponent)
			jaxbElem = toJAXB((ReliefComponent)cityGML);
		
		return jaxbElem;
	}

}
