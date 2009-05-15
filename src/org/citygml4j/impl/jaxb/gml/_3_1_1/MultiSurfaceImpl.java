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

	public List<SurfaceProperty> getSurfaceMember() {
		List<SurfaceProperty> surfacePropertyList = new ArrayList<SurfaceProperty>();

		for (SurfacePropertyType surfacePropertyType : multiSurfaceType.getSurfaceMember())
			surfacePropertyList.add(new SurfacePropertyImpl(surfacePropertyType));

		return surfacePropertyList;
	}

	public SurfaceArrayProperty getSurfaceMembers() {
		if (multiSurfaceType.isSetSurfaceMembers())
			return new SurfaceArrayPropertyImpl(multiSurfaceType.getSurfaceMembers());

		return null;
	}

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

	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		multiSurfaceType.getSurfaceMember().add(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
	}

	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		List<SurfacePropertyType> surfacePropertyList = new ArrayList<SurfacePropertyType>();

		for (SurfaceProperty surfaceProperty : surfaceMember)
			surfacePropertyList.add(((SurfacePropertyImpl)surfaceProperty).getJAXBObject());

		multiSurfaceType.unsetSurfaceMember();
		multiSurfaceType.getSurfaceMember().addAll(surfacePropertyList);
	}

	public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
		multiSurfaceType.setSurfaceMembers(((SurfaceArrayPropertyImpl)surfaceMembers).getJAXBObject());
	}

	public boolean isSetSurfaceMember() {
		return multiSurfaceType.isSetSurfaceMember();
	}

	public boolean isSetSurfaceMembers() {
		return multiSurfaceType.isSetSurfaceMembers();
	}

	public void unsetSurfaceMember() {
		multiSurfaceType.unsetSurfaceMember();
	}

	public void unsetSurfaceMembers() {
		multiSurfaceType.setSurfaceMembers(null);
	}

	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		if (multiSurfaceType.isSetSurfaceMember())
			return multiSurfaceType.getSurfaceMember().remove(((SurfacePropertyImpl)surfaceMember).getJAXBObject());
		
		return false;
	}

}
