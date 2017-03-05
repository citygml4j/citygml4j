/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.marshal.citygml.relief;

import javax.xml.bind.JAXBElement;

import net.opengis.citygml.relief._1.AbstractReliefComponentType;
import net.opengis.citygml.relief._1.BreaklineReliefType;
import net.opengis.citygml.relief._1.GridPropertyType;
import net.opengis.citygml.relief._1.MassPointReliefType;
import net.opengis.citygml.relief._1.ObjectFactory;
import net.opengis.citygml.relief._1.RasterReliefType;
import net.opengis.citygml.relief._1.ReliefComponentPropertyType;
import net.opengis.citygml.relief._1.ReliefFeatureType;
import net.opengis.citygml.relief._1.TINReliefType;
import net.opengis.citygml.relief._1.TinPropertyType;
import net.opengis.gml.RectifiedGridCoverageType;
import net.opengis.gml.TriangulatedSurfaceType;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.common.base.ModelObject;

public class Relief100Marshaller {
	private final ObjectFactory dem = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Relief100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof ReliefModuleComponent)
			src = marshal((ReliefModuleComponent)src);
		
		if (src instanceof BreaklineReliefType)
			dest = dem.createBreaklineRelief((BreaklineReliefType)src);
		else if (src instanceof MassPointReliefType)
			dest = dem.createMassPointRelief((MassPointReliefType)src);
		else if (src instanceof RasterReliefType)
			dest = dem.createRasterRelief((RasterReliefType)src);
		else if (src instanceof ReliefFeatureType)
			dest = dem.createReliefFeature((ReliefFeatureType)src);
		else if (src instanceof TINReliefType)
			dest = dem.createTINRelief((TINReliefType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof BreaklineRelief)
			dest = marshalBreaklineRelief((BreaklineRelief)src);
		else if (src instanceof GridProperty)
			dest = marshalGridProperty((GridProperty)src);
		else if (src instanceof MassPointRelief)
			dest = marshalMassPointRelief((MassPointRelief)src);
		else if (src instanceof RasterRelief)
			dest = marshalRasterRelief((RasterRelief)src);
		else if (src instanceof ReliefComponentProperty)
			dest = marshalReliefComponentProperty((ReliefComponentProperty)src);
		else if (src instanceof ReliefFeature)
			dest = marshalReliefFeature((ReliefFeature)src);
		else if (src instanceof TinProperty)
			dest = marshalTinProperty((TinProperty)src);
		else if (src instanceof TINRelief)
			dest = marshalTINRelief((TINRelief)src);
		
		return dest;
	}
	
	public void marshalAbstractReliefComponent(AbstractReliefComponent src, AbstractReliefComponentType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetExtent())
			dest.setExtent(jaxb.getGMLMarshaller().marshalPolygonProperty(src.getExtent()));
		
		if (src.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfReliefComponent()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfReliefComponent().add(jaxbElement);
			}
		}
	}
	
	public void marshalBreaklineRelief(BreaklineRelief src, BreaklineReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getRidgeOrValleyLines()));
		
		if (src.isSetBreaklines())
			dest.setBreaklines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getBreaklines()));
		
		if (src.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBreaklineRelief()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBreaklineRelief().add(jaxbElement);
			}
		}
	}
	
	public GridPropertyType marshalGridProperty(GridProperty src) {
		GridPropertyType dest = dem.createGridPropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetRectifiedGridCoverage()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getRectifiedGridCoverage());
			if (elem != null && elem.getValue() instanceof RectifiedGridCoverageType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public BreaklineReliefType marshalBreaklineRelief(BreaklineRelief src) {
		BreaklineReliefType dest = dem.createBreaklineReliefType();
		marshalBreaklineRelief(src, dest);

		return dest;
	}
	
	public void marshalMassPointRelief(MassPointRelief src, MassPointReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetReliefPoints())
			dest.setReliefPoints(jaxb.getGMLMarshaller().marshalMultiPointProperty(src.getReliefPoints()));
		
		if (src.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfMassPointRelief()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfMassPointRelief().add(jaxbElement);
			}
		}
	}
	
	public MassPointReliefType marshalMassPointRelief(MassPointRelief src) {
		MassPointReliefType dest = dem.createMassPointReliefType();
		marshalMassPointRelief(src, dest);

		return dest;
	}
	
	public void marshalRasterRelief(RasterRelief src, RasterReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetGrid())
			dest.setGrid(marshalGridProperty(src.getGrid()));
		
		if (src.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfRasterRelief()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfRasterRelief().add(jaxbElement);
			}
		}
	}
	
	public RasterReliefType marshalRasterRelief(RasterRelief src) {
		RasterReliefType dest = dem.createRasterReliefType();
		marshalRasterRelief(src, dest);

		return dest;
	}
	
	public ReliefComponentPropertyType marshalReliefComponentProperty(ReliefComponentProperty src) {
		ReliefComponentPropertyType dest = dem.createReliefComponentPropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetReliefComponent()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getReliefComponent());
			if (elem != null && elem.getValue() instanceof AbstractReliefComponentType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public void marshalReliefFeature(ReliefFeature src, ReliefFeatureType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : src.getReliefComponent())
				dest.getReliefComponent().add(marshalReliefComponentProperty(reliefComponentProperty));
		}
		
		if (src.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfReliefFeature()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfReliefFeature().add(jaxbElement);
			}
		}
	}
	
	public ReliefFeatureType marshalReliefFeature(ReliefFeature src) {
		ReliefFeatureType dest = dem.createReliefFeatureType();
		marshalReliefFeature(src, dest);

		return dest;
	}
	
	public TinPropertyType marshalTinProperty(TinProperty src) {
		TinPropertyType dest = dem.createTinPropertyType();
		jaxb.getGMLMarshaller().marshalAssociationByRepOrRef(src, dest);

		if (src.isSetTriangulatedSurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTriangulatedSurface());
			if (elem != null && elem.getValue() instanceof TriangulatedSurfaceType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public void marshalTINRelief(TINRelief src, TINReliefType dest) {
		marshalAbstractReliefComponent(src, dest);
		
		if (src.isSetTin())
			dest.setTin(marshalTinProperty(src.getTin()));
		
		if (src.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTinRelief()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTinRelief().add(jaxbElement);
			}
		}
	}
	
	public TINReliefType marshalTINRelief(TINRelief src) {
		TINReliefType dest = dem.createTINReliefType();
		marshalTINRelief(src, dest);

		return dest;
	}
	
}
