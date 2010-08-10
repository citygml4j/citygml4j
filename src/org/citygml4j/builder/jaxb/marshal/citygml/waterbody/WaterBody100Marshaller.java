package org.citygml4j.builder.jaxb.marshal.citygml.waterbody;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.AbstractWaterObjectType;
import org.citygml4j.jaxb.citygml.wtr._1.BoundedByWaterSurfacePropertyType;
import org.citygml4j.jaxb.citygml.wtr._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.wtr._1.WaterBodyType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterSurfaceType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterBody100Marshaller {
	private final ObjectFactory wtr = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public WaterBody100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof WaterBodyModuleComponent)
			src = marshal(src);
		
		if (src instanceof WaterBodyType)
			dest = wtr.createWaterBody((WaterBodyType)src);
		else if (src instanceof WaterClosureSurfaceType)
			dest = wtr.createWaterClosureSurface((WaterClosureSurfaceType)src);
		else if (src instanceof WaterGroundSurfaceType)
			dest = wtr.createWaterGroundSurface((WaterGroundSurfaceType)src);
		else if (src instanceof WaterSurfaceType)
			dest = wtr.createWaterSurface((WaterSurfaceType)src);
		
		return dest;
	}
	
	public Object marshal(Object src) {
		Object dest = null;
		
		if (src instanceof BoundedByWaterSurfaceProperty)
			dest = marshalBoundedByWaterSurfaceProperty((BoundedByWaterSurfaceProperty)src);
		else if (src instanceof WaterBody)
			dest = marshalWaterBody((WaterBody)src);
		else if (src instanceof WaterClosureSurface)
			dest = marshalWaterClosureSurface((WaterClosureSurface)src);
		else if (src instanceof WaterGroundSurface)
			dest = marshalWaterGroundSurface((WaterGroundSurface)src);
		else if (src instanceof WaterSurface)
			dest = marshalWaterSurface((WaterSurface)src);
		
		return dest;
	}
	
	public void marshalWaterObject(AbstractWaterObject src, AbstractWaterObjectType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterObject())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterObject().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public void marshalWaterBoundarySurface(AbstractWaterBoundarySurface src, AbstractWaterBoundarySurfaceType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);
		
		if (src.isSetLod2Surface())
			dest.setLod2Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod2Surface()));
		
		if (src.isSetLod3Surface())
			dest.setLod3Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod3Surface()));
		
		if (src.isSetLod4Surface())
			dest.setLod4Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod4Surface()));
		
		if (src.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterBoundarySurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterBoundarySurface().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public BoundedByWaterSurfacePropertyType marshalBoundedByWaterSurfaceProperty(BoundedByWaterSurfaceProperty src) {
		BoundedByWaterSurfacePropertyType dest = wtr.createBoundedByWaterSurfacePropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetWaterBoundarySurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getWaterBoundarySurface());
			if (elem != null && elem.getValue() instanceof AbstractWaterBoundarySurfaceType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public void marshalWaterBody(WaterBody src, WaterBodyType dest) {
		marshalWaterObject(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());
		
		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod0MultiSurface()));
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod0MultiCurve())
			dest.setLod0MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod0MultiCurve()));
		
		if (src.isSetLod1MultiCurve())
			dest.setLod1MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1MultiCurve()));
		
		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod1Solid()));
		
		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod2Solid()));
		
		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod3Solid()));
		
		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod4Solid()));
		
		if (src.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundedByWaterSurfaceProperty(boundedByWaterSurfaceProperty));
		}
		
		if (src.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterBody())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterBody().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public WaterBodyType marshalWaterBody(WaterBody src) {
		WaterBodyType dest = wtr.createWaterBodyType();
		marshalWaterBody(src, dest);

		return dest;
	}
	
	public void marshalWaterClosureSurface(WaterClosureSurface src, WaterClosureSurfaceType dest) {
		marshalWaterBoundarySurface(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterClosureSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterClosureSurface().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public WaterClosureSurfaceType marshalWaterClosureSurface(WaterClosureSurface src) {
		WaterClosureSurfaceType dest = wtr.createWaterClosureSurfaceType();
		marshalWaterClosureSurface(src, dest);

		return dest;
	}
	
	public void marshalWaterGroundSurface(WaterGroundSurface src, WaterGroundSurfaceType dest) {
		marshalWaterBoundarySurface(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterGroundSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterGroundSurface().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public WaterGroundSurfaceType marshalWaterGroundSurface(WaterGroundSurface src) {
		WaterGroundSurfaceType dest = wtr.createWaterGroundSurfaceType();
		marshalWaterGroundSurface(src, dest);

		return dest;
	}
	
	public void marshalWaterSurface(WaterSurface src, WaterSurfaceType dest) {
		marshalWaterBoundarySurface(src, dest);
		
		if (src.isSetWaterLevel())
			dest.setWaterLevel(src.getWaterLevel());
		
		if (src.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWaterSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWaterSurface().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public WaterSurfaceType marshalWaterSurface(WaterSurface src) {
		WaterSurfaceType dest = wtr.createWaterSurfaceType();
		marshalWaterSurface(src, dest);

		return dest;
	}
	
}
