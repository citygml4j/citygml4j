package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.BoundedByWaterSurfacePropertyType;
import org.citygml4j.jaxb.citygml._0_4.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterSurfaceType;
import org.citygml4j.jaxb.citygml._0_4._WaterBoundarySurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class BoundedByWaterSurfacePropertyImpl extends AssociationImpl<WaterBoundarySurface> implements BoundedByWaterSurfaceProperty {
	private BoundedByWaterSurfacePropertyType boundedByType;

	public BoundedByWaterSurfacePropertyImpl() {
		this(new BoundedByWaterSurfacePropertyType());
	}

	public BoundedByWaterSurfacePropertyImpl(BoundedByWaterSurfacePropertyType boundedByType) {
		super(boundedByType);
		this.boundedByType = boundedByType;
	}

	@Override
	public BoundedByWaterSurfacePropertyType getJAXBObject() {
		return boundedByType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDEDBYWATERSURFACEPROPERTY;
	}

	public final CityGMLModule getCityGMLModule() {
		return WaterBodyModule.v0_4_0;
	}
	
	public WaterBoundarySurface getObject() {
		if (boundedByType.isSet_Object()) {
			JAXBElement<?> waterBoundarySurface = boundedByType.get_Object();
			
			if (waterBoundarySurface.getValue() != null) {
				Object elem = waterBoundarySurface.getValue();
				QName name = waterBoundarySurface.getName();
				
				if (elem instanceof WaterSurfaceType)
					return ModelMapper.WTR_0_4.toCityGML((WaterSurfaceType)elem, name);
				else if (elem instanceof WaterGroundSurfaceType)
					return ModelMapper.WTR_0_4.toCityGML((WaterGroundSurfaceType)elem, name);
				else if (elem instanceof WaterClosureSurfaceType)
					return ModelMapper.WTR_0_4.toCityGML((WaterClosureSurfaceType)elem, name);
				else if (elem instanceof _WaterBoundarySurfaceType)
					return ModelMapper.WTR_0_4.toCityGML((_WaterBoundarySurfaceType)elem, name);
			}
		}

		return null;
	}

	public void setObject(WaterBoundarySurface object) {
		JAXBElement<?> jaxbElem = null;

		if (object instanceof WaterSurface)
			jaxbElem = ModelMapper.WTR_0_4.toJAXB((WaterSurface)object);
		else if (object instanceof WaterGroundSurface)
			jaxbElem = ModelMapper.WTR_0_4.toJAXB((WaterGroundSurface)object);
		else if (object instanceof WaterClosureSurface)
			jaxbElem = ModelMapper.WTR_0_4.toJAXB((WaterClosureSurface)object);
		else if (object instanceof WaterBoundarySurface)
			jaxbElem = ModelMapper.WTR_0_4.toJAXB((WaterBoundarySurface)object);

		if (jaxbElem != null)
			boundedByType.set_Object(jaxbElem);
	}

}
