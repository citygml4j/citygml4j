/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterObjectType;
import org.citygml4j.jaxb.citygml.wtr._1.BoundedByWaterSurfacePropertyType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterBodyType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterSurfaceType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class WaterBody100Unmarshaller {
	private final WaterBodyModule module = WaterBodyModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public WaterBody100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}
	
	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;
				
		if (src instanceof BoundedByWaterSurfacePropertyType)
			dest = unmarshalBoundedByWaterSurfaceProperty((BoundedByWaterSurfacePropertyType)src);
		else if (src instanceof WaterBodyType)
			dest = unmarshalWaterBody((WaterBodyType)src);
		else if (src instanceof WaterClosureSurfaceType)
			dest = unmarshalWaterClosureSurface((WaterClosureSurfaceType)src);
		else if (src instanceof WaterGroundSurfaceType)
			dest = unmarshalWaterGroundSurface((WaterGroundSurfaceType)src);
		else if (src instanceof WaterSurfaceType)
			dest = unmarshalWaterSurface((WaterSurfaceType)src);
		
		return dest;
	}
	
	public void unmarshalAbstractWaterObject(AbstractWaterObjectType src, AbstractWaterObject dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);
	}
	
	public void unmarshalAbstractWaterBoundarySurface(AbstractWaterBoundarySurfaceType src, AbstractWaterBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetLod2Surface())
			dest.setLod2Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod2Surface()));
		
		if (src.isSetLod3Surface())
			dest.setLod3Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod3Surface()));
		
		if (src.isSetLod4Surface())
			dest.setLod4Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod4Surface()));
	}

	public BoundedByWaterSurfaceProperty unmarshalBoundedByWaterSurfaceProperty(BoundedByWaterSurfacePropertyType src) throws MissingADESchemaException {
		BoundedByWaterSurfaceProperty dest = new BoundedByWaterSurfaceProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractWaterBoundarySurface)
				dest.setObject((AbstractWaterBoundarySurface)object);
		}

		return dest;
	}
	
	public void unmarshalWaterBody(WaterBodyType src, WaterBody dest) throws MissingADESchemaException {
		unmarshalAbstractWaterObject(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}
		
		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod0MultiSurface()));
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod0MultiCurve())
			dest.setLod0MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod0MultiCurve()));
		
		if (src.isSetLod1MultiCurve())
			dest.setLod1MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1MultiCurve()));
		
		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod1Solid()));
		
		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod2Solid()));
		
		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod3Solid()));
		
		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod4Solid()));
		
		if (src.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfacePropertyType boundedByWaterSurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundedByWaterSurfaceProperty(boundedByWaterSurfaceProperty));
		}
	}
	
	public WaterBody unmarshalWaterBody(WaterBodyType src) throws MissingADESchemaException {
		WaterBody dest = new WaterBody(module);
		unmarshalWaterBody(src, dest);

		return dest;
	}
	
	public void unmarshalWaterClosureSurface(WaterClosureSurfaceType src, WaterClosureSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
	}
	
	public WaterClosureSurface unmarshalWaterClosureSurface(WaterClosureSurfaceType src) throws MissingADESchemaException {
		WaterClosureSurface dest = new WaterClosureSurface(module);
		unmarshalWaterClosureSurface(src, dest);

		return dest;
	}
	
	public void unmarshalWaterGroundSurface(WaterGroundSurfaceType src, WaterGroundSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
	}
	
	public WaterGroundSurface unmarshalWaterGroundSurface(WaterGroundSurfaceType src) throws MissingADESchemaException {
		WaterGroundSurface dest = new WaterGroundSurface(module);
		unmarshalWaterGroundSurface(src, dest);

		return dest;
	}
	
	public void unmarshalWaterSurface(WaterSurfaceType src, WaterSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
		
		if (src.isSetWaterLevel())
			dest.setWaterLevel(new Code(src.getWaterLevel()));
	}
	
	public WaterSurface unmarshalWaterSurface(WaterSurfaceType src) throws MissingADESchemaException {
		WaterSurface dest = new WaterSurface(module);
		unmarshalWaterSurface(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractWaterObject && name.equals("_GenericApplicationPropertyOfWaterObject"))
			((AbstractWaterObject)dest).addGenericApplicationPropertyOfWaterObject(genericProperty);		
		else if (dest instanceof AbstractWaterBoundarySurface && name.equals("_GenericApplicationPropertyOfWaterBoundarySurface"))
			((AbstractWaterBoundarySurface)dest).addGenericApplicationPropertyOfWaterBoundarySurface(genericProperty);		
		else if (dest instanceof WaterBody && name.equals("_GenericApplicationPropertyOfWaterBody"))
			((WaterBody)dest).addGenericApplicationPropertyOfWaterBody(genericProperty);		
		else if (dest instanceof WaterClosureSurface && name.equals("_GenericApplicationPropertyOfWaterClosureSurface"))
			((WaterClosureSurface)dest).addGenericApplicationPropertyOfWaterClosureSurface(genericProperty);		
		else if (dest instanceof WaterGroundSurface && name.equals("_GenericApplicationPropertyOfWaterGroundSurface"))
			((WaterGroundSurface)dest).addGenericApplicationPropertyOfWaterGroundSurface(genericProperty);		
		else if (dest instanceof WaterSurface && name.equals("_GenericApplicationPropertyOfWaterSurface"))
			((WaterSurface)dest).addGenericApplicationPropertyOfWaterSurface(genericProperty);		
		else
			success = false;
		
		return success;
	}
	
}
