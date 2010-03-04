package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;

public enum CurveInterpolation implements GML, Copyable {
	LINEAR("linear"),
    GEODESIC("geodesic"),
    CIRCULAR_ARC_3_POINTS("circularArc3Points"),
    CIRCULAR_ARC_2_POINT_WITH_BULGE("circularArc2PointWithBulge"),
    CIRCULAR_ARC_CENTER_POINT_WITH_RADIUS("circularArcCenterPointWithRadius"),
    ELLIPTICAL("elliptical"),
    CLOTHOID("clothoid"),
    CONIC("conic"),
    POLYNOMIAL_SPLINE("polynomialSpline"),
    CUBIC_SPLINE("cubicSpline"),
    RATIONAL_SPLINE("rationalSpline");
	
    private final String value;
    
    CurveInterpolation(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static CurveInterpolation fromValue(String v) {
    	v = v.trim();
    	
        for (CurveInterpolation c : CurveInterpolation.values())
            if (c.value.equals(v))
                return c;

        return LINEAR;
    }

	public GMLClass getGMLClass() {
		return GMLClass.CURVEINTERPOLATION;
	}
    
	public String toString() {
		return value;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? LINEAR : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
}
