package org.citygml4j.binding.json.geometry;

import com.google.gson.annotations.SerializedName;

public enum GeometryTypeName {
	@SerializedName("MultiPoint")
	MULTI_POINT("MultiPoint", MultiPointType.class),
	@SerializedName("MultiLineString")
	MULTI_LINE_STRING("MultiLineString", MultiLineStringType.class),
	@SerializedName("MultiSurface")
	MULTI_SURFACE("MultiSurface", MultiSurfaceType.class),
	@SerializedName("CompositeSurface")
	COMPOSITE_SURFACE("CompositeSurface", CompositeSurfaceType.class),
	@SerializedName("Solid")
	SOLID("Solid", SolidType.class),
	@SerializedName("MultiSolid")
	MULTI_SOLID("MultiSolid", MultiSolidType.class),
	@SerializedName("CompositeSolid")
	COMPOSITE_SOLID("CompositeSolid", CompositeSolidType.class);
	
	private final String value;
	private final Class<? extends AbstractGeometryType> typeClass;
	
	private GeometryTypeName(String value, Class<? extends AbstractGeometryType> typeClass) {
		this.value = value;
		this.typeClass = typeClass;
	}
	
	public String getValue() {
		return value;
	}
	
	public Class<? extends AbstractGeometryType> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return value;
	}
	
	public static GeometryTypeName fromValue(String value) {
		for (GeometryTypeName type : GeometryTypeName.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
