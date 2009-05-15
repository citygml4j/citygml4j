package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml._0_4.CeilingSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.ClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.FloorSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.GroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.InteriorWallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.RoofSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4._BoundarySurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.WallSurface;

public class BoundarySurfacePropertyImpl extends AssociationImpl<BoundarySurface> implements BoundarySurfaceProperty {
	private BoundarySurfacePropertyType boundarySurfacePropertyType;

	public BoundarySurfacePropertyImpl() {
		this(new BoundarySurfacePropertyType());
	}

	public BoundarySurfacePropertyImpl(BoundarySurfacePropertyType boundarySurfacePropertyType) {
		super(boundarySurfacePropertyType);
		this.boundarySurfacePropertyType = boundarySurfacePropertyType;
	}

	@Override
	public BoundarySurfacePropertyType getJAXBObject() {
		return boundarySurfacePropertyType;
	}

	public BoundarySurface getObject() {
		if (boundarySurfacePropertyType.isSet_Object()) {
			JAXBElement<?> boundarySurface = boundarySurfacePropertyType.get_Object();
			
			if (boundarySurface.getValue() != null) {
				Object elem = boundarySurface.getValue();
				QName name = boundarySurface.getName();
				
				if (elem instanceof RoofSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((RoofSurfaceType)elem, name);
				else if (elem instanceof WallSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((WallSurfaceType)elem, name);
				else if (elem instanceof GroundSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((GroundSurfaceType)elem, name);
				else if (elem instanceof ClosureSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((ClosureSurfaceType)elem, name);
				else if (elem instanceof FloorSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((FloorSurfaceType)elem, name);
				else if (elem instanceof InteriorWallSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((InteriorWallSurfaceType)elem, name);
				else if (elem instanceof CeilingSurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((CeilingSurfaceType)elem, name);
				else if (elem instanceof _BoundarySurfaceType)
					return ModelMapper.BLDG_0_4.toCityGML((_BoundarySurfaceType)elem, name);
			}
		}

		return null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDARYSURFACEPROPERTY;
	}

	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	public void setObject(BoundarySurface object) {
		JAXBElement<?> jaxbElem = null;

		if (object instanceof RoofSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((RoofSurface)object);
		else if (object instanceof WallSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((WallSurface)object);
		else if (object instanceof GroundSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((GroundSurface)object);
		else if (object instanceof ClosureSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((ClosureSurface)object);
		else if (object instanceof FloorSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((FloorSurface)object);
		else if (object instanceof InteriorWallSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((InteriorWallSurface)object);
		else if (object instanceof CeilingSurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((CeilingSurface)object);
		else if (object instanceof BoundarySurface)
			jaxbElem = ModelMapper.BLDG_0_4.toJAXB((BoundarySurface)object);

		if (jaxbElem != null)
			boundarySurfacePropertyType.set_Object(jaxbElem);
	}
	
}
