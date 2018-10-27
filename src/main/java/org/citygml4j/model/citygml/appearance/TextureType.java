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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
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
