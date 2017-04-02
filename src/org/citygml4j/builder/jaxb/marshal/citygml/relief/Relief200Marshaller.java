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
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import net.opengis.citygml.relief._2.AbstractReliefComponentType;
import net.opengis.citygml.relief._2.BreaklineReliefType;
import net.opengis.citygml.relief._2.GridPropertyType;
import net.opengis.citygml.relief._2.MassPointReliefType;
import net.opengis.citygml.relief._2.ObjectFactory;
import net.opengis.citygml.relief._2.RasterReliefType;
import net.opengis.citygml.relief._2.ReliefComponentPropertyType;
import net.opengis.citygml.relief._2.ReliefFeatureType;
import net.opengis.citygml.relief._2.TINReliefType;
import net.opengis.citygml.relief._2.TinPropertyType;
import net.opengis.gml.RectifiedGridCoverageType;
import net.opengis.gml.TriangulatedSurfaceType;

public class Relief200Marshaller {
	private final ObjectFactory dem = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Relief200Marshaller(CityGMLMarshaller citygml) {
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
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);
		
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
	
	@SuppressWarnings("unchecked")
	public GridPropertyType marshalGridProperty(GridProperty src) {
		GridPropertyType dest = dem.createGridPropertyType();

		if (src.isSetRectifiedGridCoverage()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getRectifiedGridCoverage());
			if (elem != null && elem.getValue() instanceof RectifiedGridCoverageType)
				dest.set_Object((JAXBElement<? extends RectifiedGridCoverageType>)elem);
		}
		
		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

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
	
	@SuppressWarnings("unchecked")
	public ReliefComponentPropertyType marshalReliefComponentProperty(ReliefComponentProperty src) {
		ReliefComponentPropertyType dest = dem.createReliefComponentPropertyType();

		if (src.isSetReliefComponent()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getReliefComponent());
			if (elem != null && elem.getValue() instanceof AbstractReliefComponentType)
				dest.set_ReliefComponent((JAXBElement<? extends AbstractReliefComponentType>)elem);
		}
		
		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public void marshalReliefFeature(ReliefFeature src, ReliefFeatureType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);
		
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
	
	@SuppressWarnings("unchecked")
	public TinPropertyType marshalTinProperty(TinProperty src) {
		TinPropertyType dest = dem.createTinPropertyType();

		if (src.isSetTriangulatedSurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTriangulatedSurface());
			if (elem != null && elem.getValue() instanceof TriangulatedSurfaceType)
				dest.setTriangulatedSurface((JAXBElement<? extends TriangulatedSurfaceType>)elem);
		}
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

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
