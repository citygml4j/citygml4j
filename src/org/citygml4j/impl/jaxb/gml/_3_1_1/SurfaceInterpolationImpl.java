package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfaceInterpolation;

public enum SurfaceInterpolationImpl implements SurfaceInterpolation {
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
    
    SurfaceInterpolationImpl(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static SurfaceInterpolationImpl fromValue(String v) {
    	v = v.trim();
    	
        for (SurfaceInterpolationImpl c: SurfaceInterpolationImpl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return NONE;
    }

	public GMLClass getGMLClass() {
		return GMLClass.SURFACEINTERPOLATION;
	}
    
	public String toString() {
		return value;
	}
	
	public boolean equals(GMLBase other) {
		return super.equals(other);
	}
}
