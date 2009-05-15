package org.citygml4j.impl.jaxb.citygml.waterbody._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterObjectType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterBodyType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterSurfaceType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterBody100ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public WaterBody toCityGML(WaterBodyType waterBody, QName name) {		
		if (waterBody.getClass().equals(WaterBodyType.class))
			return new WaterBodyImpl(waterBody);
		else
			return (WaterBody)jaxb2ade(waterBody, name, WaterBody.class);
	}
	
	public WaterClosureSurface toCityGML(WaterClosureSurfaceType waterClosureSurface, QName name) {		
		if (waterClosureSurface.getClass().equals(WaterClosureSurfaceType.class))
			return new WaterClosureSurfaceImpl(waterClosureSurface);
		else 
			return (WaterClosureSurface)jaxb2ade(waterClosureSurface, name, WaterClosureSurface.class);
	}
	
	public WaterGroundSurface toCityGML(WaterGroundSurfaceType waterGroundSurface, QName name) {		
		if (waterGroundSurface.getClass().equals(WaterGroundSurfaceType.class))
			return new WaterGroundSurfaceImpl(waterGroundSurface);
		else 
			return (WaterGroundSurface)jaxb2ade(waterGroundSurface, name, WaterGroundSurface.class);
	}
	
	public WaterSurface toCityGML(WaterSurfaceType waterSurface, QName name) {		
		if (waterSurface.getClass().equals(WaterSurfaceType.class))
			return new WaterSurfaceImpl(waterSurface);
		else 
			return (WaterSurface)jaxb2ade(waterSurface, name, WaterSurface.class);
	}
	
	public WaterObject toCityGML(AbstractWaterObjectType waterObject, QName name) {		
		// we are just checking ADEs
		return (WaterObject)jaxb2ade(waterObject, name, WaterObject.class);
	}
	
	public WaterBoundarySurface toCityGML(AbstractWaterBoundarySurfaceType waterBoundarySurface, QName name) {		
		// we are just checking ADEs
		return (WaterBoundarySurface)jaxb2ade(waterBoundarySurface, name, WaterBoundarySurface.class);
	}
	
	public JAXBElement<? extends WaterBodyType> toJAXB(WaterBody waterBody) {
		if (!(waterBody instanceof ADEComponent))
			return ObjectFactory.WTR_1.createWaterBody(((WaterBodyImpl)waterBody).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterBody, WaterBodyType.class);
	}
	
	public JAXBElement<? extends WaterClosureSurfaceType> toJAXB(WaterClosureSurface waterClosureSurface) {
		if (!(waterClosureSurface instanceof ADEComponent))
			return ObjectFactory.WTR_1.createWaterClosureSurface(((WaterClosureSurfaceImpl)waterClosureSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterClosureSurface, WaterClosureSurfaceType.class);
	}
	
	public JAXBElement<? extends WaterGroundSurfaceType> toJAXB(WaterGroundSurface waterGroundSurface) {
		if (!(waterGroundSurface instanceof ADEComponent))
			return ObjectFactory.WTR_1.createWaterGroundSurface(((WaterGroundSurfaceImpl)waterGroundSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterGroundSurface, WaterGroundSurfaceType.class);
	}
	
	public JAXBElement<? extends WaterSurfaceType> toJAXB(WaterSurface waterSurface) {
		if (!(waterSurface instanceof ADEComponent))
			return ObjectFactory.WTR_1.createWaterSurface(((WaterSurfaceImpl)waterSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterSurface, WaterSurfaceType.class);
	}
	
	public JAXBElement<? extends AbstractWaterObjectType> toJAXB(WaterObject waterObject) {
		// we are just checking ADEs
		if (waterObject instanceof ADEComponent)
			return ade2jaxb((ADEComponent)waterObject, AbstractWaterObjectType.class);
		
		return null;
	}
	
	public JAXBElement<? extends AbstractWaterBoundarySurfaceType> toJAXB(WaterBoundarySurface waterBoundarySurface) {
		// we are just checking ADEs
		if (waterBoundarySurface instanceof ADEComponent)
			return ade2jaxb((ADEComponent)waterBoundarySurface, AbstractWaterBoundarySurfaceType.class);
		
		return null;
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {		
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof WaterBodyType)
				cityGMLBase = toCityGML((WaterBodyType)value, name);
			else if (value instanceof WaterClosureSurfaceType)
				cityGMLBase = toCityGML((WaterClosureSurfaceType)value, name);
			else if (value instanceof WaterGroundSurfaceType)
				cityGMLBase = toCityGML((WaterGroundSurfaceType)value, name);
			else if (value instanceof WaterSurfaceType)
				cityGMLBase = toCityGML((WaterSurfaceType)value, name);	
			else if (value instanceof AbstractWaterObjectType)
				cityGMLBase = toCityGML((AbstractWaterObjectType)value, name);	
			else if (value instanceof AbstractWaterBoundarySurfaceType)
				cityGMLBase = toCityGML((AbstractWaterBoundarySurfaceType)value, name);
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof WaterBody)
			jaxbElem = toJAXB((WaterBody)cityGML);
		else if (cityGML instanceof WaterClosureSurface)
			jaxbElem = toJAXB((WaterClosureSurface)cityGML);
		else if (cityGML instanceof WaterGroundSurface)
			jaxbElem = toJAXB((WaterGroundSurface)cityGML);
		else if (cityGML instanceof WaterSurface)
			jaxbElem = toJAXB((WaterSurface)cityGML);		
		else if (cityGML instanceof WaterObject)
			jaxbElem = toJAXB((WaterObject)cityGML);	
		else if (cityGML instanceof WaterBoundarySurface)
			jaxbElem = toJAXB((WaterBoundarySurface)cityGML);
		
		return jaxbElem;
	}
	
}
