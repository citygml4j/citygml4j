package org.citygml4j.builder.jaxb.unmarshal.citygml.relief;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.relief.BreaklineReliefImpl;
import org.citygml4j.impl.citygml.relief.GridPropertyImpl;
import org.citygml4j.impl.citygml.relief.MassPointReliefImpl;
import org.citygml4j.impl.citygml.relief.RasterReliefImpl;
import org.citygml4j.impl.citygml.relief.ReliefComponentPropertyImpl;
import org.citygml4j.impl.citygml.relief.ReliefFeatureImpl;
import org.citygml4j.impl.citygml.relief.TINReliefImpl;
import org.citygml4j.impl.citygml.relief.TinPropertyImpl;
import org.citygml4j.jaxb.citygml.dem._1.AbstractReliefComponentType;
import org.citygml4j.jaxb.citygml.dem._1.BreaklineReliefType;
import org.citygml4j.jaxb.citygml.dem._1.GridPropertyType;
import org.citygml4j.jaxb.citygml.dem._1.MassPointReliefType;
import org.citygml4j.jaxb.citygml.dem._1.RasterReliefType;
import org.citygml4j.jaxb.citygml.dem._1.ReliefComponentPropertyType;
import org.citygml4j.jaxb.citygml.dem._1.ReliefFeatureType;
import org.citygml4j.jaxb.citygml.dem._1.TINReliefType;
import org.citygml4j.jaxb.citygml.dem._1.TinPropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.gml.RectifiedGridCoverage;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Relief100Unmarshaller {
	private final ReliefModule module = ReliefModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Relief100Unmarshaller(CityGMLUnmarshaller citygml) {
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
					
		if (src instanceof BreaklineReliefType)
			dest = unmarshalBreaklineRelief((BreaklineReliefType)dest);
		else if (src instanceof GridPropertyType)
			dest = unmarshalGridProperty((GridPropertyType)src);
		else if (src instanceof MassPointReliefType)
			dest = unmarshalMassPointRelief((MassPointReliefType)src);
		else if (src instanceof RasterReliefType)
			dest = unmarshalRasterRelief((RasterReliefType)src);
		else if (src instanceof ReliefComponentPropertyType)
			dest = unmarshalReliefComponentProperty((ReliefComponentPropertyType)src);
		else if (src instanceof ReliefFeatureType)
			dest = unmarshalReliefFeature((ReliefFeatureType)src);
		else if (src instanceof TinPropertyType)
			dest = unmarshalTinProperty((TinPropertyType)src);
		else if (src instanceof TINReliefType)
			dest = unmarshalTINRelief((TINReliefType)src);
		
		return dest;
	}

	public void unmarshalReliefComponent(AbstractReliefComponentType src, ReliefComponent dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetExtent())
			dest.setExtent(jaxb.getGMLUnmarshaller().unmarshalPolygonProperty(src.getExtent()));
	}
	
	public void unmarshalBreaklineRelief(BreaklineReliefType src, BreaklineRelief dest) throws MissingADESchemaException {
		unmarshalReliefComponent(src, dest);
		
		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getRidgeOrValleyLines()));
		
		if (src.isSetBreaklines())
			dest.setBreaklines(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getBreaklines()));
	}
	
	public BreaklineRelief unmarshalBreaklineRelief(BreaklineReliefType src) throws MissingADESchemaException {
		BreaklineRelief dest = new BreaklineReliefImpl(module);
		unmarshalBreaklineRelief(src, dest);

		return dest;
	}
	
	public GridProperty unmarshalGridProperty(GridPropertyType src) throws MissingADESchemaException {
		GridProperty dest = new GridPropertyImpl();
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);
		
		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof RectifiedGridCoverage)
				dest.setObject((RectifiedGridCoverage)object);
		}
		
		return dest;
	}
	
	public void unmarshalMassPointRelief(MassPointReliefType src, MassPointRelief dest) throws MissingADESchemaException {
		unmarshalReliefComponent(src, dest);
		
		if (src.isSetReliefPoints())
			dest.setReliefPoints(jaxb.getGMLUnmarshaller().unmarshalMultiPointProperty(src.getReliefPoints()));
	}
	
	public MassPointRelief unmarshalMassPointRelief(MassPointReliefType src) throws MissingADESchemaException {
		MassPointRelief dest = new MassPointReliefImpl(module);
		unmarshalMassPointRelief(src, dest);

		return dest;
	}
	
	public void unmarshalRasterRelief(RasterReliefType src, RasterRelief dest) throws MissingADESchemaException {
		unmarshalReliefComponent(src, dest);
		
		if (src.isSetGrid())
			dest.setGrid(unmarshalGridProperty(src.getGrid()));
	}
	
	public RasterRelief unmarshalRasterRelief(RasterReliefType src) throws MissingADESchemaException {
		RasterRelief dest = new RasterReliefImpl(module);
		unmarshalRasterRelief(src, dest);

		return dest;
	}

	public ReliefComponentProperty unmarshalReliefComponentProperty(ReliefComponentPropertyType src) throws MissingADESchemaException {
		ReliefComponentProperty dest = new ReliefComponentPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof ReliefComponent)
				dest.setObject((ReliefComponent)object);
		}

		return dest;
	}
	
	public void unmarshalReliefFeature(ReliefFeatureType src, ReliefFeature dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetReliefComponent()) {
			for (ReliefComponentPropertyType reliefComponentProperty : src.getReliefComponent())
				dest.addReliefComponent(unmarshalReliefComponentProperty(reliefComponentProperty));
		}
	}
	
	public ReliefFeature unmarshalReliefFeature(ReliefFeatureType src) throws MissingADESchemaException {
		ReliefFeature dest = new ReliefFeatureImpl(module);
		unmarshalReliefFeature(src, dest);

		return dest;
	}

	public TinProperty unmarshalTinProperty(TinPropertyType src) throws MissingADESchemaException {
		TinProperty dest = new TinPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof TriangulatedSurface)
				dest.setObject((TriangulatedSurface)object);
		}

		return dest;
	}
	
	public void unmarshalTINRelief(TINReliefType src, TINRelief dest) throws MissingADESchemaException {
		unmarshalReliefComponent(src, dest);
		
		if (src.isSetTin())
			dest.setTin(unmarshalTinProperty(src.getTin()));
	}
	
	public TINRelief unmarshalTINRelief(TINReliefType src) throws MissingADESchemaException {
		TINRelief dest = new TINReliefImpl(module);
		unmarshalTINRelief(src, dest);

		return dest;
	}	
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof ReliefComponent && name.equals("_GenericApplicationPropertyOfReliefComponent"))
			((ReliefComponent)dest).addGenericApplicationPropertyOfReliefComponent(genericProperty);
		else if (dest instanceof BreaklineRelief && name.equals("_GenericApplicationPropertyOfBreaklineRelief"))
			((BreaklineRelief)dest).addGenericApplicationPropertyOfBreaklineRelief(genericProperty);
		else if (dest instanceof MassPointRelief && name.equals("_GenericApplicationPropertyOfMassPointRelief"))
			((MassPointRelief)dest).addGenericApplicationPropertyOfMassPointRelief(genericProperty);
		else if (dest instanceof RasterRelief && name.equals("_GenericApplicationPropertyOfRasterRelief"))
			((RasterRelief)dest).addGenericApplicationPropertyOfRasterRelief(genericProperty);
		else if (dest instanceof ReliefFeature && name.equals("_GenericApplicationPropertyOfReliefFeature"))
			((ReliefFeature)dest).addGenericApplicationPropertyOfReliefFeature(genericProperty);
		else if (dest instanceof TINRelief && name.equals("_GenericApplicationPropertyOfTinRelief"))
			((TINRelief)dest).addGenericApplicationPropertyOfTinRelief(genericProperty);
		else 
			success = false;
		
		return success;
	}
	
}
