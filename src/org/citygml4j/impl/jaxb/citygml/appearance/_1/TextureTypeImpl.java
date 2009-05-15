package org.citygml4j.impl.jaxb.citygml.appearance._1;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.TextureType;

public enum TextureTypeImpl implements TextureType {
    SPECIFIC("specific"),
    TYPICAL("typical"),
    UNKNOWN("unknown");
    
    private final String value;

    TextureTypeImpl(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TextureTypeImpl fromValue(String v) {
    	v = v.trim().toLowerCase();
    	
        for (TextureTypeImpl c: TextureTypeImpl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return UNKNOWN;
    }

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURETYPE;
	}

	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v1_0_0;
	}

	public String toString() {
		return value;
	}
	
}
