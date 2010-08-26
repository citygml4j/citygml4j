package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

public enum WrapMode implements AppearanceModuleComponent, Copyable {
	NONE("none"),
	WRAP("wrap"),
	MIRROR("mirror"),
	CLAMP("clamp"),
	BORDER("border");

	private final String value;
	private AppearanceModule module;

	WrapMode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static WrapMode fromValue(String v) {
		v = v.trim().toLowerCase();

		for (WrapMode c: WrapMode.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return NONE;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WRAP_MODE;
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
		return (target == null) ? NONE : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
	
}