/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: SurfaceInterpolation.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum SurfaceInterpolation implements GML, Copyable {
	NONE("none"),
	PLANAR("planar"),
	SPHERICAL("spherical"),
	ELLIPTICAL("elliptical"),
	CONIC("conic"),
	TIN("tin"),
	PARAMETRIC_CURVE("parametricCurve"),
	POLYNOMIAL_SPLINE("polynomialSpline"),
	RATIONAL_SPLINE("rationalSpline"),
	TRIANGULATED_SPLINE("triangulatedSpline");

	private final String value;

	SurfaceInterpolation(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static SurfaceInterpolation fromValue(String v) {
		v = v.trim();

		for (SurfaceInterpolation c: SurfaceInterpolation.values())
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
		return GMLClass.SURFACE_INTERPOLATION;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? NONE : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
