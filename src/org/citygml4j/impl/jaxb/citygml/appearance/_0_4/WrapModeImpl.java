package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.WrapMode;

public enum WrapModeImpl implements WrapMode {
	NONE("none"),
	WRAP("wrap"),
	MIRROR("mirror"),
	CLAMP("clamp"),
	BORDER("border");
	
	private final String value;

	WrapModeImpl(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static WrapModeImpl fromValue(String v) {
		v = v.trim().toLowerCase();
		
		for (WrapModeImpl c: WrapModeImpl.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return NONE;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WRAPMODE;
	}

	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}
	
	public String toString() {
		return value;
	}
}
