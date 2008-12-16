package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePropertyType;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class MultiSurfaceImpl extends AbstractGeometricAggregateImpl implements MultiSurface {
	private MultiSurfaceType multiSurfaceType;

	public MultiSurfaceImpl() {
		this(new MultiSurfaceType());
	}

	public MultiSurfaceImpl(MultiSurfaceType multiSurfaceType) {
		super(multiSurfaceType);
		this.multiSurfaceType = multiSurfaceType;
	}

	@Override
	public MultiSurfaceType getJAXBObject() {
		return multiSurfaceType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTISURFACE;
	}

	@Override
	public List<SurfaceProperty> getSurfaceMember() {
		List<SurfaceProperty> surfacePropertyList = new ArrayList<SurfaceProperty>();
		List<SurfacePropertyType> surfacePropertyTypeList = multiSurfaceType.getSurfaceMember();

		for (SurfacePropertyType surfacePropertyType : surfacePropertyTypeList)
			surfacePropertyList.add(new SurfacePropertyImpl(surfacePropertyType));

		return surfacePropertyList;
	}

	@Override
	public SurfaceArrayProperty getSurfaceMembers() {
		if (multiSurfaceType.isSetSurfaceMembers())
			return new SurfaceArrayPropertyImpl(multiSurfaceType.getSurfaceMembers());

		return null;
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

		if (isSetSurfaceMembers()) {
			SurfaceArrayProperty surfaceArrayProperty = getSurfaceMembers();

			if (surfaceArrayProperty.isSetSurface()) {
				for (AbstractSurface abstractSurface : surfaceArrayProperty.getSurface()) {
					abstractSurface.calcBoundingBox(min, max);
				}
			}
		}
	}

	@Override
	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		multiSurfaceType.getSurfaceMember().add(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
	}

	@Override
	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		List<SurfacePropertyType> surfacePropertyList = new ArrayList<SurfacePropertyType>();

		for (SurfaceProperty surfaceProperty : surfaceMember)
			surfacePropertyList.add(((SurfacePropertyImpl)surfaceProperty).getJAXBObject());

		multiSurfaceType.unsetSurfaceMember();
		multiSurfaceType.getSurfaceMember().addAll(surfacePropertyList);
	}

	@Override
	public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
		multiSurfaceType.setSurfaceMembers(((SurfaceArrayPropertyImpl)surfaceMembers).getJAXBObject());
	}

	@Override
	public boolean isSetSurfaceMember() {
		return multiSurfaceType.isSetSurfaceMember();
	}

	@Override
	public boolean isSetSurfaceMembers() {
		return multiSurfaceType.isSetSurfaceMembers();
	}

	@Override
	public void unsetSurfaceMember() {
		multiSurfaceType.unsetSurfaceMember();
	}

	@Override
	public void unsetSurfaceMembers() {
		multiSurfaceType.setSurfaceMembers(null);
	}

	@Override
	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		if (multiSurfaceType.isSetSurfaceMember())
			return multiSurfaceType.getSurfaceMember().remove(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
		
		return false;
	}

}
