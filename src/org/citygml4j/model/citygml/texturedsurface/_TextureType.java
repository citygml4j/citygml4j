package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public enum _TextureType implements TexturedSurfaceModuleComponent, Copyable {
    SPECIFIC("specific"),
    TYPICAL("typical"),
    UNKNOWN("unknown");
    
    private final String value;
    private TexturedSurfaceModule module;

    _TextureType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static _TextureType fromValue(String v) {
    	v = v.trim().toLowerCase();
    	
        for (_TextureType c: _TextureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return UNKNOWN;
    }

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._TEXTURE_TYPE;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
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
