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
package org.citygml4j.model.gml.xlink;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum XLinkActuate implements GML, Copyable {
	ON_LOAD("onLoad"),
	ON_REQUEST("onRequest"),
	OTHER("other"),
	NONE("none");

	private final String value;

	XLinkActuate(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static XLinkActuate fromValue(String v) {
		v = v.trim();

		for (XLinkActuate c: XLinkActuate.values())
			if (c.value.equals(v))
				return c;

		return NONE;
	}

	public String toString() {
		return value;
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.XLINK_ACTUATE;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? NONE : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
