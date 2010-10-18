/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum IncrementOrder implements GML, Copyable {
	PLUS_X_PLUS_Y("+x+y"),
    PLUS_Y_PLUS_X("+y+x"),
    PLUS_X_MINUS_Y("+x-y"),
    MINUS_X_MINUS_Y("-x-y");

	private final String value;

	IncrementOrder(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static IncrementOrder fromValue(String v) {
		v = v.trim();

		for (IncrementOrder c: IncrementOrder.values())
			if (c.value.equals(v))
				return c;

		return PLUS_X_PLUS_Y;
	}

	public String toString() {
		return value;
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INCREMENT_ORDER;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? PLUS_X_PLUS_Y : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
