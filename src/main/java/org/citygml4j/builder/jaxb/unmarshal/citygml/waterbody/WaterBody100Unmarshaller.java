/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody;

import net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody._1.AbstractWaterObjectType;
import net.opengis.citygml.waterbody._1.BoundedByWaterSurfacePropertyType;
import net.opengis.citygml.waterbody._1.WaterBodyType;
import net.opengis.citygml.waterbody._1.WaterClosureSurfaceType;
import net.opengis.citygml.waterbody._1.WaterGroundSurfaceType;
import net.opengis.citygml.waterbody._1.WaterSurfaceType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class WaterBody100Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final WaterBodyModule module = WaterBodyModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public WaterBody100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(BoundedByWaterSurfacePropertyType.class, this::unmarshalBoundedByWaterSurfaceProperty)
							.with(WaterBodyType.class, this::unmarshalWaterBody)
							.with(WaterClosureSurfaceType.class, this::unmarshalWaterClosureSurface)
							.with(WaterGroundSurfaceType.class, this::unmarshalWaterGroundSurface)
							.with(WaterSurfaceType.class, this::unmarshalWaterSurface)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractWaterObject(AbstractWaterObjectType src, AbstractWaterObject dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSet_GenericApplicationPropertyOfWaterObject()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterObject()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterObject(ade);
			}
		}
	}

	public void unmarshalAbstractWaterBoundarySurface(AbstractWaterBoundarySurfaceType src, AbstractWaterBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetLod2Surface())
			dest.setLod2Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod2Surface()));

		if (src.isSetLod3Surface())
			dest.setLod3Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod3Surface()));

		if (src.isSetLod4Surface())
			dest.setLod4Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod4Surface()));

		if (src.isSet_GenericApplicationPropertyOfWaterBoundarySurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterBoundarySurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterBoundarySurface(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfWaterBody()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterBody()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterBody(ade);
			}
		}
	}

	public WaterBody unmarshalWaterBody(WaterBodyType src) throws MissingADESchemaException {
		WaterBody dest = new WaterBody(module);
		unmarshalWaterBody(src, dest);

		return dest;
	}

	public void unmarshalWaterClosureSurface(WaterClosureSurfaceType src, WaterClosureSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfWaterClosureSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterClosureSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterClosureSurface(ade);
			}
		}
	}

	public WaterClosureSurface unmarshalWaterClosureSurface(WaterClosureSurfaceType src) throws MissingADESchemaException {
		WaterClosureSurface dest = new WaterClosureSurface(module);
		unmarshalWaterClosureSurface(src, dest);

		return dest;
	}

	public void unmarshalWaterGroundSurface(WaterGroundSurfaceType src, WaterGroundSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfWaterGroundSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterGroundSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterGroundSurface(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfWaterSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWaterSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWaterSurface(ade);
			}
		}
	}

	public WaterSurface unmarshalWaterSurface(WaterSurfaceType src) throws MissingADESchemaException {
		WaterSurface dest = new WaterSurface(module);
		unmarshalWaterSurface(src, dest);

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
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
