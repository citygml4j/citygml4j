package org.citygml4j.binding.json.geometry;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(GeometryTypeAdapter.class)
public abstract class AbstractGeometryType {
	private Number lod = 0;

	public abstract GeometryTypeName getType();

	public boolean isSetLod() {
		return lod != null;
	}
	
	public Number getLod() {
		return lod;
	}

	public void setLod(Number lod) {
		if (lod.doubleValue() >= 0 && lod.doubleValue() < 4)
			this.lod = lod;
	}

}
