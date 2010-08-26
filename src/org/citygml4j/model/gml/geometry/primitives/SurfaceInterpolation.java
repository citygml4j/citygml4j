package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
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
