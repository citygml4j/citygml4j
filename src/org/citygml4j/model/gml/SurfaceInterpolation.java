package org.citygml4j.model.gml;

public interface SurfaceInterpolation extends GMLBase {
	public static String NONE = "none";
	public static String PLANAR = "planar";
	public static String SPHERICAL = "spherical";
	public static String ELLIPTICAL = "elliptical";
	public static String CONIC = "conic";
	public static String TIN = "tin";
	public static String PARAMETRIC_CURVE = "parametricCurve";
	public static String POLYNOMIAL_SPLINE = "polynomialSpline";
	public static String RATIONAL_SPLINE = "rationalSpline";
	public static String TRIANGULATED_SPLINE = "triangulatedSpline";
	
	public String getValue();
}
