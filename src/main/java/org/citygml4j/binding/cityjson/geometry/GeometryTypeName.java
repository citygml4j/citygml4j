/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.binding.cityjson.geometry;

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
	COMPOSITE_SOLID("CompositeSolid", CompositeSolidType.class),
	@SerializedName("GeometryInstance")
	GEOMETRY_INSTANCE("GeometryInstance", GeometryInstanceType.class);
	
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
