package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.TriangulatedSurface;

public class TriangulatedSurfaceImpl extends SurfaceImpl implements TriangulatedSurface {
	private TriangulatedSurfaceType triangulatedSurfaceType;
	
	public TriangulatedSurfaceImpl() {
		this(new TriangulatedSurfaceType());
	}
	
	public TriangulatedSurfaceImpl(TriangulatedSurfaceType triangulatedSurfaceType) {
		super(triangulatedSurfaceType);
		this.triangulatedSurfaceType = triangulatedSurfaceType;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGULATEDSURFACE;
	}

	@Override
	public TriangulatedSurfaceType getJAXBObject() {
		return triangulatedSurfaceType;
	}

	@Override
	public TrianglePatchArrayProperty getPatches() {
		if (super.getPatches() != null) {
			SurfacePatchArrayProperty patchProperty = super.getPatches();
			if (patchProperty.getGMLClass() == GMLClass.TRIANGLEPATCHARRAYPROPERTY)
				return (TrianglePatchArrayProperty)patchProperty;
		}
		
		return null;			
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches.getGMLClass() == GMLClass.TRIANGLEPATCHARRAYPROPERTY)
			super.setPatches(patches);
	}

	@Override
	public TrianglePatchArrayProperty getTrianglePatches() {
		return getPatches();
	}

	@Override
	public void setTrianglePatches(TrianglePatchArrayProperty trianglePatches) {
		super.setPatches(trianglePatches);
	}

	@Override
	public boolean isSetTrianglePatches() {
		return triangulatedSurfaceType.isSetPatches();
	}

	@Override
	public void unsetTrianglePatches() {
		triangulatedSurfaceType.setPatches(null);
	}

}
