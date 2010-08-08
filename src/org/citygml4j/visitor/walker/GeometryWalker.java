package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeCurveProperty;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.Curve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.Grid;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.LineStringProperty;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.LinearRingProperty;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiLineString;
import org.citygml4j.model.gml.MultiLineStringProperty;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.MultiPointProperty;
import org.citygml4j.model.gml.MultiPolygon;
import org.citygml4j.model.gml.MultiPolygonProperty;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.OrientableCurve;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;
import org.citygml4j.model.gml.PriorityLocationProperty;
import org.citygml4j.model.gml.Rectangle;
import org.citygml4j.model.gml.RectifiedGrid;
import org.citygml4j.model.gml.Ring;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.Surface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;
import org.citygml4j.model.gml.Tin;
import org.citygml4j.model.gml.Triangle;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.visitor.GeometryVisitor;

public abstract class GeometryWalker implements GeometryVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true; 
	
	public void reset() {
		visited.clear();
		shouldWalk = true;
	}
	
	public boolean shouldWalk() {
		return shouldWalk;
	}
	
	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}
	
	public boolean addToVisited(Object object) {
		return visited.add(object);
	}
	
	public boolean hasVisited(Object object) {
		return visited.contains(object);
	}
	
	public void accept(AbstractGeometry abstractGeometry) {
	}

	public void accept(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		accept((AbstractGeometry)abstractGeometricPrimitive);
	}

	public void accept(AbstractGeometricAggregate abstractGeometricAggregate) {
		accept((AbstractGeometry)abstractGeometricAggregate);
	}

	public void accept(AbstractCurve abstractCurve) {
		accept((AbstractGeometricPrimitive)abstractCurve);
	}

	public void accept(AbstractSolid abstractSolid) {
		accept((AbstractGeometricPrimitive)abstractSolid);
	}

	public void accept(AbstractSurface abstractSurface) {
		accept((AbstractGeometricPrimitive)abstractSurface);
	}

	public void accept(AbstractRing abstractRing) {
		accept((AbstractGeometry)abstractRing);
	}
	
	public void accept(PointProperty pointProperty) {
		if (pointProperty.isSetPoint() && shouldWalk && visited.add(pointProperty.getPoint()))
			pointProperty.getPoint().visit(this);
	}

	public void accept(CurveProperty curveProperty) {
		if (curveProperty.isSetCurve() && shouldWalk && visited.add(curveProperty.getCurve()))
			curveProperty.getCurve().visit(this);
	}

	public void accept(PolygonProperty polygonProperty) {
		if (polygonProperty.isSetPolygon() && shouldWalk && visited.add(polygonProperty.getPolygon()))
			polygonProperty.getPolygon().visit(this);
	}

	public void accept(SurfaceProperty surfaceProperty) {
		if (surfaceProperty.isSetSurface() && shouldWalk && visited.add(surfaceProperty.getSurface()))
			surfaceProperty.getSurface().visit(this);
	}	

	public void accept(SolidProperty solidProperty) {
		if (solidProperty.isSetSolid() && shouldWalk && visited.add(solidProperty.getSolid()))
			solidProperty.getSolid().visit(this);
	}
	
	public void accept(CompositeCurveProperty compositeCurveProperty) {
		if (compositeCurveProperty.isSetCompositeCurve() && shouldWalk && visited.add(compositeCurveProperty.getCompositeCurve()))
			compositeCurveProperty.getCompositeCurve().visit(this);
	}
	
	public void accept(CompositeSolidProperty compositeSolidProperty) {
		if (compositeSolidProperty.isSetCompositeSolid() && shouldWalk && visited.add(compositeSolidProperty.getCompositeSolid()))
			compositeSolidProperty.getCompositeSolid().visit(this);
	}
	
	public void accept(CompositeSurfaceProperty compositeSurfaceProperty) {
		if (compositeSurfaceProperty.isSetCompositeSurface() && shouldWalk && visited.add(compositeSurfaceProperty.getCompositeSurface()))
			compositeSurfaceProperty.getCompositeSurface().visit(this);
	}

	public void accept(MultiPointProperty multiPointProperty) {
		if (multiPointProperty.isSetMultiPoint() && shouldWalk && visited.add(multiPointProperty.getMultiPoint()))
			multiPointProperty.getMultiPoint().visit(this);
	}
	
	public void accept(MultiCurveProperty multiCurveProperty) {
		if (multiCurveProperty.isSetMultiCurve() && shouldWalk && visited.add(multiCurveProperty.getMultiCurve()))
			multiCurveProperty.getMultiCurve().visit(this);
	}
	
	public void accept(MultiLineStringProperty multiLineStringProperty) {
		if (multiLineStringProperty.isSetMultiLineString() && shouldWalk && visited.add(multiLineStringProperty.getMultiLineString()))
			multiLineStringProperty.getMultiLineString().visit(this);
	}
	
	public void accept(MultiSurfaceProperty multiSurfaceProperty) {
		if (multiSurfaceProperty.isSetMultiSurface() && shouldWalk && visited.add(multiSurfaceProperty.getMultiSurface()))
			multiSurfaceProperty.getMultiSurface().visit(this);
	}
	
	public void accept(MultiPolygonProperty multiPolygonProperty) {
		if (multiPolygonProperty.isSetMultiPolygon() && shouldWalk && visited.add(multiPolygonProperty.getMultiPolygon()))
			multiPolygonProperty.getMultiPolygon().visit(this);
	}
		
	public void accept(MultiSolidProperty multiSolidProperty) {
		if (multiSolidProperty.isSetMultiSolid() && shouldWalk && visited.add(multiSolidProperty.getMultiSolid()))
			multiSolidProperty.getMultiSolid().visit(this);
	}
	
	public void accept(GeometryProperty geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().visit(this);
	}
	
	public void accept(GeometricPrimitiveProperty geometricPrimitiveProperty) {
		if (geometricPrimitiveProperty.isSetGeometricPrimitive() && shouldWalk && visited.add(geometricPrimitiveProperty.getGeometricPrimitive()))
			geometricPrimitiveProperty.getGeometricPrimitive().visit(this);
	}
	
	public void accept(GeometricComplexProperty geometricComplexProperty) {
		if (geometricComplexProperty.isSetGeometricComplex() && shouldWalk && visited.add(geometricComplexProperty.getGeometricComplex()))
			geometricComplexProperty.getGeometricComplex().visit(this);
		
		if (geometricComplexProperty.isSetCompositeCurve() && shouldWalk && visited.add(geometricComplexProperty.getCompositeCurve()))
			geometricComplexProperty.getCompositeCurve().visit(this);
		
		if (geometricComplexProperty.isSetCompositeSolid() && shouldWalk && visited.add(geometricComplexProperty.getCompositeSolid()))
			geometricComplexProperty.getCompositeSolid().visit(this);
		
		if (geometricComplexProperty.isSetCompositeSurface() && shouldWalk && visited.add(geometricComplexProperty.getCompositeSurface()))
			geometricComplexProperty.getCompositeSurface().visit(this);
	}

	public void accept(CurveArrayProperty curveArrayProperty) {
		if (curveArrayProperty.isSetCurve())
			for (AbstractCurve abstractCurve : new ArrayList<AbstractCurve>(curveArrayProperty.getCurve()))
				if (shouldWalk && visited.add(abstractCurve))
					abstractCurve.visit(this);
	}

	public void accept(LinearRingProperty linearRingProperty) {
		if (linearRingProperty.isSetLinearRing() && shouldWalk && visited.add(linearRingProperty.getLinearRing()))
			linearRingProperty.getLinearRing().visit(this);
	}
	
	public void accept(LineStringProperty lineStringProperty) {
		if (lineStringProperty.isSetLineString() && shouldWalk && visited.add(lineStringProperty.getLineString()))
			lineStringProperty.getLineString().visit(this);
	}

	public void accept(PointArrayProperty pointArrayProperty) {
		if (pointArrayProperty.isSetPoint())
			for (Point point : new ArrayList<Point>(pointArrayProperty.getPoint()))
				if (shouldWalk && visited.add(point))
					point.visit(this);
	}

	public void accept(SolidArrayProperty solidArrayProperty) {
		if (solidArrayProperty.isSetSolid())
			for (AbstractSolid abstractSolid : new ArrayList<AbstractSolid>(solidArrayProperty.getSolid()))
				if (shouldWalk && visited.add(abstractSolid))
					abstractSolid.visit(this);
	}

	public void accept(SurfaceArrayProperty surfaceArrayProperty) {
		if (surfaceArrayProperty.isSetSurface())
			for (AbstractSurface abstractSurface : new ArrayList<AbstractSurface>(surfaceArrayProperty.getSurface()))
				if (shouldWalk && visited.add(abstractSurface))
					abstractSurface.visit(this);
	}

	public void accept(AbstractRingProperty abstractRingProperty) {
		if (abstractRingProperty.isSetRing() && shouldWalk && visited.add(abstractRingProperty.getRing()))
			abstractRingProperty.getRing().visit(this);
	}

	public void accept(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		if (surfacePatchArrayProperty.isSetSurfacePatch())
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk && visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle)
						accept((Triangle)abstractSurfacePatch);
					else if (abstractSurfacePatch instanceof Rectangle)
						accept((Rectangle)abstractSurfacePatch);
				}
			}
	}

	public void accept(TrianglePatchArrayProperty trianglePatchArrayProperty) {
		accept((SurfacePatchArrayProperty)trianglePatchArrayProperty);
	}
	
	public void accept(LocationProperty locationProperty) {
		if (locationProperty.isSetGeometry() && shouldWalk && visited.add(locationProperty.getGeometry()))
			locationProperty.getGeometry().visit(this);
	}
	
	public void accept(PriorityLocationProperty priorityLocationProperty) {
		accept((LocationProperty)priorityLocationProperty);
	}

	public void accept(Triangle triangle) {
		if (triangle.isSetExterior())
			accept(triangle.getExterior());
	}

	public void accept(Rectangle rectangle) {
		if (rectangle.isSetExterior())
			accept(rectangle.getExterior());
	}

	public void accept(CompositeCurve compositeCurve) {
		for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember()))
			accept(curveProperty);
		
		accept((AbstractCurve)compositeCurve);
	}

	public void accept(CompositeSolid compositeSolid) {
		for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember()))
			accept(solidProperty);
		
		accept((AbstractSolid)compositeSolid);
	}

	public void accept(CompositeSurface compositeSurface) {
		for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember()))
			accept(surfaceProperty);
		
		accept((AbstractSurface)compositeSurface);
	}

	public void accept(Curve curve) {
		accept((AbstractCurve)curve);
	}

	public void accept(GeometricComplex geometricComplex) {
		if (geometricComplex.isSetElement())
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement()))
				accept(geometricPrimitiveProperty);
		
		accept((AbstractGeometry)geometricComplex);
	}
	
	public void accept(Grid grid) {
		accept((AbstractGeometry)grid);
	}

	public void accept(LinearRing linearRing) {
		accept((AbstractRing)linearRing);
	}

	public void accept(LineString lineString) {
		accept((AbstractCurve)lineString);
	}

	public void accept(MultiCurve multiCurve) {
		if (multiCurve.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember()))
				accept(curveProperty);

		if (multiCurve.isSetCurveMembers())
			accept(multiCurve.getCurveMembers());
		
		accept((AbstractGeometricAggregate)multiCurve);
	}

	public void accept(MultiLineString multiLineString) {
		if (multiLineString.isSetLineStringMember())
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember()))
				accept(lineStringProperty);
		
		accept((AbstractGeometricAggregate)multiLineString);
	}

	public void accept(MultiPoint multiPoint) {
		if (multiPoint.isSetPointMember())
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember()))
				accept(pointProperty);

		if (multiPoint.isSetPointMembers())
			accept(multiPoint.getPointMembers());
		
		accept((AbstractGeometricAggregate)multiPoint);
	}

	public void accept(MultiPolygon multiPolygon) {
		if (multiPolygon.isSetPolygonMember())
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember()))
				accept(polygonProperty);
		
		accept((AbstractGeometricAggregate)multiPolygon);
	}

	public void accept(MultiSolid multiSolid) {
		if (multiSolid.isSetSolidMember())
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember()))
				accept(solidProperty);

		if (multiSolid.isSetSolidMembers())
			accept(multiSolid.getSolidMembers());
		
		accept((AbstractGeometricAggregate)multiSolid);
	}

	public void accept(MultiSurface multiSurface) {
		if (multiSurface.isSetSurfaceMember())
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember()))
				accept(surfaceProperty);

		if (multiSurface.isSetSurfaceMembers())
			accept(multiSurface.getSurfaceMembers());
		
		accept((AbstractGeometricAggregate)multiSurface);
	}

	public void accept(OrientableCurve orientableCurve) {
		if (orientableCurve.isSetBaseCurve())
			accept(orientableCurve.getBaseCurve());
		
		accept((AbstractCurve)orientableCurve);

	}

	public void accept(OrientableSurface orientableSurface) {
		if (orientableSurface.isSetBaseSurface())
			accept(orientableSurface.getBaseSurface());
		
		accept((AbstractSurface)orientableSurface);
	}
	
	public void accept(_TexturedSurface texturedSurface) {
		accept((OrientableSurface)texturedSurface);
	}

	public void accept(Point point) {
		accept((AbstractGeometricPrimitive)point);
	}

	public void accept(Polygon polygon) {
		if (polygon.isSetExterior())
			accept(polygon.getExterior());

		if (polygon.isSetInterior())
			for (AbstractRingProperty interior : new ArrayList<AbstractRingProperty>(polygon.getInterior()))
				accept(interior);
		
		accept((AbstractSurface)polygon);
	}
	
	public void accept(RectifiedGrid rectifiedGrid) {
		if (rectifiedGrid.isSetOrigin())
			accept(rectifiedGrid.getOrigin());
		
		accept((Grid)rectifiedGrid);
	}

	public void accept(Ring ring) {
		if (ring.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember()))
				accept(curveProperty);
		
		accept((AbstractRing)ring);
	}

	public void accept(Solid solid) {
		if (solid.isSetExterior())
			accept(solid.getExterior());

		if (solid.isSetInterior())
			for (SurfaceProperty interior : new ArrayList<SurfaceProperty>(solid.getInterior()))
				accept(interior);
		
		accept((AbstractSolid)solid);
	}

	public void accept(Surface surface) {
		if (surface.isSetPatches())
			accept(surface.getPatches());
		
		accept((AbstractSurface)surface);
	}

	public void accept(Tin tin) {
		accept((TriangulatedSurface)tin);
	}

	public void accept(TriangulatedSurface triangulatedSurface) {
		accept((Surface)triangulatedSurface);
	}

}
