package org.citygml4j.builder.json.objects;

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
	
	private final String name;
	private final Class<? extends AbstractGeometryType> typeClass;
	
	private GeometryTypeName(String name, Class<? extends AbstractGeometryType> typeClass) {
		this.name = name;
		this.typeClass = typeClass;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends AbstractGeometryType> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static GeometryTypeName fromName(String name) {
		for (GeometryTypeName type : GeometryTypeName.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
