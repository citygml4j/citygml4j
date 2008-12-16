package org.citygml4j.model.gml;

public interface CurveInterpolation extends GMLBase {
	public static String LINEAR = "linear";
	public static String GEODESIC = "geodesic";
	public static String CIRCULAR_ARC_3_POINTS = "circularArc3Points";
	public static String CIRCULAR_ARC_2_POINT_WITH_BULGE = "circularArc2PointWithBulge";
	public static String CIRCULAR_ARC_CENTER_POINT_WITH_RADIUS = "circularArcCenterPointWithRadius";
	public static String ELLIPTICAL = "elliptical";
	public static String CLOTHOID = "clothoid";
	public static String CONIC = "conic";
	public static String POLYNOMIAL_SPLINE = "polynomialSpline";
	public static String CUBIC_SPLINE = "cubicSpline";
	public static String RATIONAL_SPLINE = "rationalSpline";
	
	public String getValue();
}
