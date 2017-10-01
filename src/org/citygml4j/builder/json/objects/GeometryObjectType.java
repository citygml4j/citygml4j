package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum GeometryObjectType {
	@SerializedName("MultiPoint")
	MULTI_POINT("MultiPoint", MultiPoint.class),
	@SerializedName("MultiLineString")
	MULTI_LINE_STRING("MultiLineString", MultiLineString.class),
	@SerializedName("MultiSurface")
	MULTI_SURFACE("MultiSurface", MultiSurface.class),
	@SerializedName("CompositeSurface")
	COMPOSITE_SURFACE("CompositeSurface", CompositeSurface.class),
	@SerializedName("Solid")
	SOLID("Solid", Solid.class),
	@SerializedName("MultiSolid")
	MULTI_SOLID("MultiSolid", MultiSolid.class),
	@SerializedName("CompositeSolid")
	COMPOSITE_SOLID("CompositeSolid", CompositeSolid.class);
	
	private final String name;
	private final Class<? extends AbstractGeometryObject> typeClass;
	
	private GeometryObjectType(String name, Class<? extends AbstractGeometryObject> typeClass) {
		this.name = name;
		this.typeClass = typeClass;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends AbstractGeometryObject> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static GeometryObjectType fromName(String name) {
		for (GeometryObjectType type : GeometryObjectType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
