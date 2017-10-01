package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(GeometryObjectAdapter.class)
public abstract class AbstractGeometryObject {
	private Number lod = 0;

	public abstract GeometryObjectType getType();

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
