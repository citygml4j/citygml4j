/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

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

	public String toString() {
		return value;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.CURVE_INTERPOLATION;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? LINEAR : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}
}
