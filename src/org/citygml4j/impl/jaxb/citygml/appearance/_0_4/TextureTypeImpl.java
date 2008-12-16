package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

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

    @Override
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

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURETYPE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	public String toString() {
		return value;
	}
}
