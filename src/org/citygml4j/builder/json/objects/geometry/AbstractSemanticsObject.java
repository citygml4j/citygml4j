package org.citygml4j.builder.json.objects.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSemanticsObject {
	private List<SemanticsType> surfaces;

	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract List<Integer> flatValues();

	public boolean isSetSurfaces() {
		return surfaces != null;
	}

	public void addSurface(SemanticsType surface) {
		if (surfaces == null)
			surfaces = new ArrayList<>();

		surfaces.add(surface);
	}

	public List<SemanticsType> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(List<SemanticsType> surfaces) {
		this.surfaces = surfaces;
	}

	public int getNumSurfaces() {
		return surfaces != null ? surfaces.size() : 0;
	}

}
