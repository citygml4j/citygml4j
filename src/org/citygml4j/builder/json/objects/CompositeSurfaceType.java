package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class CompositeSurfaceType extends AbstractGeometryType {
	private final GeometryTypeName type = GeometryTypeName.COMPOSITE_SURFACE;
	private List<List<List<Integer>>> geometry = new ArrayList<>();
	private List<SemanticsType> semantics;
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addSurface(List<List<Integer>> surface) {
		if (surface != null && surface.size() > 0)
			geometry.add(surface);
	}

	public List<List<List<Integer>>> getSurfaces() {
		return geometry;
	}

	public void setSurfaces(List<List<List<Integer>>> surfaces) {
		if (surfaces != null)
			geometry = surfaces;
	}
	
	public boolean isSetSemantics() {
		return semantics != null;
	}
	
	public void addSemantics(SemanticsType semantics) {
		if (this.semantics == null)
			this.semantics = new ArrayList<>();
		
		this.semantics.add(semantics);
	}

	public List<SemanticsType> getSemantics() {
		return semantics;
	}

	public void setSemantics(List<SemanticsType> semantics) {
		this.semantics = semantics;
	}
	
}
