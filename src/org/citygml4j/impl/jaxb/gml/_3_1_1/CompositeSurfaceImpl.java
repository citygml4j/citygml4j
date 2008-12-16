package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePropertyType;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfaceProperty;

public class CompositeSurfaceImpl extends AbstractSurfaceImpl implements CompositeSurface {
	private CompositeSurfaceType compositeSurfaceType;

	public CompositeSurfaceImpl() {
		this(new CompositeSurfaceType());
	}

	public CompositeSurfaceImpl(CompositeSurfaceType compositeSurfaceType) {
		super(compositeSurfaceType);
		this.compositeSurfaceType = compositeSurfaceType;
	}

	@Override
	public CompositeSurfaceType getJAXBObject() {
		return compositeSurfaceType;
	}

	@Override
	public List<SurfaceProperty> getSurfaceMember() {
		List<SurfaceProperty> surfacePropertyList = new ArrayList<SurfaceProperty>();
		List<SurfacePropertyType> surfacePropertyTypeList = compositeSurfaceType.getSurfaceMember();

		for (SurfacePropertyType surfacePropertyType : surfacePropertyTypeList)
			surfacePropertyList.add(new SurfacePropertyImpl(surfacePropertyType));

		return surfacePropertyList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITESURFACE;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : getSurfaceMember()) {
				AbstractSurface abstractSurface = surfaceProperty.getSurface();
				if (abstractSurface != null)
					abstractSurface.calcBoundingBox(min, max);
			}
		}
	}

	@Override
	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		compositeSurfaceType.getSurfaceMember().add(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
	}

	@Override
	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		List<SurfacePropertyType> surfacePropertyList = new ArrayList<SurfacePropertyType>();

		for (SurfaceProperty surfaceProperty : surfaceMember)
			surfacePropertyList.add(((SurfacePropertyImpl)surfaceProperty).getJAXBObject());

		compositeSurfaceType.unsetSurfaceMember();
		compositeSurfaceType.getSurfaceMember().addAll(surfacePropertyList);
	}

	@Override
	public boolean isSetSurfaceMember() {
		return compositeSurfaceType.isSetSurfaceMember();
	}

	@Override
	public void unsetSurfaceMember() {
		compositeSurfaceType.unsetSurfaceMember();
	}

	@Override
	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		if (compositeSurfaceType.isSetSurfaceMember())
			return compositeSurfaceType.getSurfaceMember().remove(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
			
		return false;
	}

}
