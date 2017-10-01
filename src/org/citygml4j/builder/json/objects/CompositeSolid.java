package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class CompositeSolid extends AbstractGeometryObject {
	private final GeometryObjectType type = GeometryObjectType.COMPOSITE_SOLID;
	private List<List<List<List<List<Integer>>>>> geometry = new ArrayList<>();
	private List<List<List<Semantics>>> semantics;

	@Override
	public GeometryObjectType getType() {
		return type;
	}
	
	public void addSolid(List<List<List<List<Integer>>>> solid) {
		if (solid != null && solid.size() > 0)
			geometry.add(solid);
	}

	public List<List<List<List<List<Integer>>>>> getSolids() {
		return geometry;
	}

	public void setSolids(List<List<List<List<List<Integer>>>>> solids) {
		if (solids != null)
			geometry = solids;
	}
	
	public boolean isSetSemantics() {
		return semantics != null;
	}
	
	public void addSemantics(List<List<Semantics>> semantics) {
		if (this.semantics == null)
			this.semantics = new ArrayList<>();
		
		this.semantics.add(semantics);
	}

	public List<List<List<Semantics>>> getSemantics() {
		return semantics;
	}

	public void setSemantics(List<List<List<Semantics>>> semantics) {
		this.semantics = semantics;
	}
	
}
