package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.gml.geometry.primitives.Rectangle;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.RectifiedGrid;
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
	
	public void accept(GeometryProperty<? extends AbstractGeometry> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().visit(this);
	}
	
	public void accept(InlineGeometryProperty<? extends AbstractGeometry> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().visit(this);
	}

	public void accept(GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry()))
				if (shouldWalk && visited.add(abstractGeometry))
					abstractGeometry.visit(this);
		}
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

}
