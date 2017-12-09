package org.citygml4j.binding.cityjson.feature;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TransportationComplexAttributes extends Attributes {
	@SerializedName("surfaceMaterial")
	private List<String> surfaceMaterials;
	
	public boolean isSetSurfaceMaterials() {
		return surfaceMaterials != null;
	}
	
	public void addSurfaceMaterial(String surfaceMaterial) {
		if (surfaceMaterials == null)
			surfaceMaterials = new ArrayList<>();
		
		surfaceMaterials.add(surfaceMaterial);
	}

	public List<String> getSurfaceMaterials() {
		return surfaceMaterials;
	}

	public void setSurfaceMaterials(List<String> surfaceMaterial) {
		this.surfaceMaterials = surfaceMaterial;
	}
	
	public void unsetSurfaceMaterials() {
		surfaceMaterials = null;
	}

	@Override
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| surfaceMaterials != null;
	}
	
}
