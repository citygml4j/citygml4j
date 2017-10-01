package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class Solid extends AbstractGeometryObject {
	private final GeometryObjectType type = GeometryObjectType.SOLID;
	private List<List<List<List<Integer>>>> geometry = new ArrayList<>();
	private List<List<Semantics>> semantics;

	@Override
	public GeometryObjectType getType() {
		return type;
	}

	public void addShell(List<List<List<Integer>>> shell) {
		if (shell != null && shell.size() > 0)
			geometry.add(shell);
	}

	public List<List<List<List<Integer>>>> getShells() {
		return geometry;
	}

	public void setShells(List<List<List<List<Integer>>>> shells) {
		if (shells != null)
			geometry = shells;
	}
	
	public boolean isSetSemantics() {
		return semantics != null;
	}
	
	public void addSemantics(List<Semantics> semantics) {
		if (this.semantics == null)
			this.semantics = new ArrayList<>();
		
		this.semantics.add(semantics);
	}

	public List<List<Semantics>> getSemantics() {
		return semantics;
	}

	public void setSemantics(List<List<Semantics>> semantics) {
		this.semantics = semantics;
	}
	
}
