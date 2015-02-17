/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

public enum TextureType implements AppearanceModuleComponent, Copyable {
    SPECIFIC("specific"),
    TYPICAL("typical"),
    UNKNOWN("unknown");
    
    private final String value;
    private AppearanceModule module;

    TextureType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TextureType fromValue(String v) {
    	v = v.trim().toLowerCase();
    	
        for (TextureType c: TextureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return UNKNOWN;
    }

    public ModelType getModelType() {
		return ModelType.CITYGML;
	}
    
    public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_TYPE;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public String toString() {
		return value;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? UNKNOWN : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
	
}
