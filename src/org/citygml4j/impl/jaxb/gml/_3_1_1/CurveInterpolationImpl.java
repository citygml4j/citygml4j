package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.model.gml.CurveInterpolation;
import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;

public enum CurveInterpolationImpl implements CurveInterpolation {
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
    
    CurveInterpolationImpl(String v) {
        value = v;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static CurveInterpolationImpl fromValue(String v) {
    	v = v.trim();
    	
        for (CurveInterpolationImpl c: CurveInterpolationImpl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return LINEAR;
    }

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SURFACEINTERPOLATION;
	}
    
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(GMLBase other) {
		return super.equals(other);
	}
	
}
