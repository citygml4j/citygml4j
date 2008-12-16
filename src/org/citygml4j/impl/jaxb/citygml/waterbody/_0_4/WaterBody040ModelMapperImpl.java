package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.WaterBodyType;
import org.citygml4j.jaxb.citygml._0_4.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterSurfaceType;
import org.citygml4j.jaxb.citygml._0_4._WaterBoundarySurfaceType;
import org.citygml4j.jaxb.citygml._0_4._WaterObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterBody040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

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
	
	public WaterObject toCityGML(_WaterObjectType waterObject, QName name) {		
		// we are just checking ADEs
		return (WaterObject)jaxb2ade(waterObject, name, WaterObject.class);
	}
	
	public WaterBoundarySurface toCityGML(_WaterBoundarySurfaceType waterBoundarySurface, QName name) {		
		// we are just checking ADEs
		return (WaterBoundarySurface)jaxb2ade(waterBoundarySurface, name, WaterBoundarySurface.class);
	}
	
	public JAXBElement<? extends WaterBodyType> toJAXB(WaterBody waterBody) {
		if (!(waterBody instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWaterBody(((WaterBodyImpl)waterBody).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterBody, WaterBodyType.class);
	}
	
	public JAXBElement<? extends WaterClosureSurfaceType> toJAXB(WaterClosureSurface waterClosureSurface) {
		if (!(waterClosureSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWaterClosureSurface(((WaterClosureSurfaceImpl)waterClosureSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterClosureSurface, WaterClosureSurfaceType.class);
	}
	
	public JAXBElement<? extends WaterGroundSurfaceType> toJAXB(WaterGroundSurface waterGroundSurface) {
		if (!(waterGroundSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWaterGroundSurface(((WaterGroundSurfaceImpl)waterGroundSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterGroundSurface, WaterGroundSurfaceType.class);
	}
	
	public JAXBElement<? extends WaterSurfaceType> toJAXB(WaterSurface waterSurface) {
		if (!(waterSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWaterSurface(((WaterSurfaceImpl)waterSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)waterSurface, WaterSurfaceType.class);
	}
	
	public JAXBElement<? extends _WaterObjectType> toJAXB(WaterObject waterObject) {
		// we are just checking ADEs
		if (waterObject instanceof ADEComponent)
			return ade2jaxb((ADEComponent)waterObject, _WaterObjectType.class);
		
		return null;
	}
	
	public JAXBElement<? extends _WaterBoundarySurfaceType> toJAXB(WaterBoundarySurface waterBoundarySurface) {
		// we are just checking ADEs
		if (waterBoundarySurface instanceof ADEComponent)
			return ade2jaxb((ADEComponent)waterBoundarySurface, _WaterBoundarySurfaceType.class);
		
		return null;
	}
	
	@Override
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
			else if (value instanceof _WaterObjectType)
				cityGMLBase = toCityGML((_WaterObjectType)value, name);	
			else if (value instanceof _WaterBoundarySurfaceType)
				cityGMLBase = toCityGML((_WaterBoundarySurfaceType)value, name);	
		}

		return cityGMLBase;
	}

	@Override
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
