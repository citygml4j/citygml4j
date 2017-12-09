package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSemanticsObject {
	private List<SemanticsType> surfaces;

	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract List<Integer> flatValues();
	public abstract void unsetValues();

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
	
	public void removeSurface(SemanticsType surface) {
		if (surfaces != null)
			surfaces.remove(surface);
	}

	public void unsetSurfaces() {
		surfaces = null;
	}
	
	public int getNumSurfaces() {
		return surfaces != null ? surfaces.size() : 0;
	}

}
