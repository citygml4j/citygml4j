package org.citygml4j.util.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.visitor.GeometryVisitor;
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

	public void visit(AbstractGeometry abstractGeometry) {
	}

	public void visit(LodRepresentation lodRepresentation) {
		if (lodRepresentation != null) {
			for (int lod = 0; lod < 5; lod++) {
				if (lodRepresentation.isSetLodRepresentation(lod))
					for (GeometryProperty<? extends AbstractGeometry> geometryProperty : lodRepresentation.getLodRepresentation(lod))
						visit(geometryProperty);
			}
		}
	}

	public void visit(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		visit((AbstractGeometry)abstractGeometricPrimitive);
	}

	public void visit(AbstractGeometricAggregate abstractGeometricAggregate) {
		visit((AbstractGeometry)abstractGeometricAggregate);
	}

	public void visit(AbstractCurve abstractCurve) {
		visit((AbstractGeometricPrimitive)abstractCurve);
	}

	public void visit(AbstractSolid abstractSolid) {
		visit((AbstractGeometricPrimitive)abstractSolid);
	}

	public void visit(AbstractSurface abstractSurface) {
		visit((AbstractGeometricPrimitive)abstractSurface);
	}

	public void visit(AbstractRing abstractRing) {
		visit((AbstractGeometry)abstractRing);
	}

	public void visit(Triangle triangle) {
		if (triangle.isSetExterior())
			visit(triangle.getExterior());
	}

	public void visit(Rectangle rectangle) {
		if (rectangle.isSetExterior())
			visit(rectangle.getExterior());
	}

	public void visit(CompositeCurve compositeCurve) {
		visit((AbstractCurve)compositeCurve);

		for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember()))
			visit(curveProperty);
	}

	public void visit(CompositeSolid compositeSolid) {
		visit((AbstractSolid)compositeSolid);

		for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember()))
			visit(solidProperty);
	}

	public void visit(CompositeSurface compositeSurface) {
		visit((AbstractSurface)compositeSurface);

		for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember()))
			visit(surfaceProperty);
	}

	public void visit(Curve curve) {
		visit((AbstractCurve)curve);
	}

	public void visit(GeometricComplex geometricComplex) {
		visit((AbstractGeometry)geometricComplex);

		if (geometricComplex.isSetElement())
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement()))
				visit(geometricPrimitiveProperty);
	}

	public void visit(Grid grid) {
		visit((AbstractGeometry)grid);
	}

	public void visit(LinearRing linearRing) {
		visit((AbstractRing)linearRing);
	}

	public void visit(LineString lineString) {
		visit((AbstractCurve)lineString);
	}

	public void visit(MultiCurve multiCurve) {
		visit((AbstractGeometricAggregate)multiCurve);

		if (multiCurve.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember()))
				visit(curveProperty);

		if (multiCurve.isSetCurveMembers())
			visit(multiCurve.getCurveMembers());
	}

	public void visit(MultiLineString multiLineString) {
		visit((AbstractGeometricAggregate)multiLineString);

		if (multiLineString.isSetLineStringMember())
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember()))
				visit(lineStringProperty);
	}

	public void visit(MultiPoint multiPoint) {
		visit((AbstractGeometricAggregate)multiPoint);

		if (multiPoint.isSetPointMember())
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember()))
				visit(pointProperty);

		if (multiPoint.isSetPointMembers())
			visit(multiPoint.getPointMembers());
	}

	public void visit(MultiPolygon multiPolygon) {
		visit((AbstractGeometricAggregate)multiPolygon);

		if (multiPolygon.isSetPolygonMember())
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember()))
				visit(polygonProperty);
	}

	public void visit(MultiSolid multiSolid) {
		visit((AbstractGeometricAggregate)multiSolid);

		if (multiSolid.isSetSolidMember())
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember()))
				visit(solidProperty);

		if (multiSolid.isSetSolidMembers())
			visit(multiSolid.getSolidMembers());
	}

	public void visit(MultiSurface multiSurface) {
		visit((AbstractGeometricAggregate)multiSurface);

		if (multiSurface.isSetSurfaceMember())
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember()))
				visit(surfaceProperty);

		if (multiSurface.isSetSurfaceMembers())
			visit(multiSurface.getSurfaceMembers());
	}

	public void visit(OrientableCurve orientableCurve) {
		visit((AbstractCurve)orientableCurve);

		if (orientableCurve.isSetBaseCurve())
			visit(orientableCurve.getBaseCurve());
	}

	public void visit(OrientableSurface orientableSurface) {
		visit((AbstractSurface)orientableSurface);

		if (orientableSurface.isSetBaseSurface())
			visit(orientableSurface.getBaseSurface());
	}

	public void visit(_TexturedSurface texturedSurface) {
		visit((OrientableSurface)texturedSurface);
	}

	public void visit(Point point) {
		visit((AbstractGeometricPrimitive)point);
	}

	public void visit(Polygon polygon) {
		visit((AbstractSurface)polygon);

		if (polygon.isSetExterior())
			visit(polygon.getExterior());

		if (polygon.isSetInterior())
			for (AbstractRingProperty interior : new ArrayList<AbstractRingProperty>(polygon.getInterior()))
				visit(interior);
	}

	public void visit(RectifiedGrid rectifiedGrid) {
		visit((Grid)rectifiedGrid);

		if (rectifiedGrid.isSetOrigin())
			visit(rectifiedGrid.getOrigin());
	}

	public void visit(Ring ring) {
		visit((AbstractRing)ring);

		if (ring.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember()))
				visit(curveProperty);
	}

	public void visit(Solid solid) {
		visit((AbstractSolid)solid);

		if (solid.isSetExterior())
			visit(solid.getExterior());

		if (solid.isSetInterior())
			for (SurfaceProperty interior : new ArrayList<SurfaceProperty>(solid.getInterior()))
				visit(interior);
	}

	public void visit(Surface surface) {
		visit((AbstractSurface)surface);

		if (surface.isSetPatches())
			visit(surface.getPatches());
	}

	public void visit(Tin tin) {
		visit((TriangulatedSurface)tin);
	}

	public void visit(TriangulatedSurface triangulatedSurface) {
		visit((Surface)triangulatedSurface);
	}

	public void visit(GeometryProperty<? extends AbstractGeometry> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().accept(this);
	}

	public void visit(InlineGeometryProperty<? extends AbstractGeometry> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().accept(this);
	}

	public void visit(GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry()))
				if (shouldWalk && visited.add(abstractGeometry))
					abstractGeometry.accept(this);
		}
	}

	public void visit(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		if (surfacePatchArrayProperty.isSetSurfacePatch())
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk && visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle)
						visit((Triangle)abstractSurfacePatch);
					else if (abstractSurfacePatch instanceof Rectangle)
						visit((Rectangle)abstractSurfacePatch);
				}
			}
	}

}
