package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._TextureType;

public enum _TextureTypeImpl implements _TextureType {
    SPECIFIC("specific"),
    TYPICAL("typical"),
    UNKNOWN("unknown");
    
    private final String value;

    _TextureTypeImpl(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static _TextureTypeImpl fromValue(String v) {
    	v = v.trim().toLowerCase();
    	
        for (_TextureTypeImpl c: _TextureTypeImpl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return UNKNOWN;
    }

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._TEXTURETYPE;
	}

	public final CityGMLModule getCityGMLModule() {
		return TexturedSurfaceModule.v1_0_0;
	}

	public String toString() {
		return value;
	}
	
}
