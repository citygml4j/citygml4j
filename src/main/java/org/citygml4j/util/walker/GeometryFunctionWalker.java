/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.util.walker;

import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometry;
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

import java.util.ArrayList;

public abstract class GeometryFunctionWalker<T> extends Walker implements GeometryFunctor<T> {

	public GeometryFunctionWalker() {
	}

	public T apply(LodRepresentation lodRepresentation) {
		if (lodRepresentation != null) {
			for (int lod = 0; lod < 5; lod++) {
				for (AssociationByRepOrRef<? extends AbstractGML> property : lodRepresentation.getRepresentation(lod)) {
					T object = apply(property);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public T apply(AbstractGeometry abstractGeometry) {
		return null;
	}

	public T apply(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		return apply((AbstractGeometry)abstractGeometricPrimitive);
	}

	public T apply(AbstractGeometricAggregate abstractGeometricAggregate) {
		return apply((AbstractGeometry)abstractGeometricAggregate);
	}

	public T apply(AbstractCurve abstractCurve) {
		return apply((AbstractGeometricPrimitive)abstractCurve);
	}

	public T apply(AbstractSolid abstractSolid) {
		return apply((AbstractGeometricPrimitive)abstractSolid);
	}

	public T apply(AbstractSurface abstractSurface) {
		return apply((AbstractGeometricPrimitive)abstractSurface);
	}

	public T apply(AbstractRing abstractRing) {
		return apply((AbstractGeometry)abstractRing);
	}

	public T apply(Triangle triangle) {
		if (triangle.isSetExterior()) {
			T object = apply(triangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Rectangle rectangle) {
		if (rectangle.isSetExterior()) {
			T object = apply(rectangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(CompositeCurve compositeCurve) {
		T object = apply((AbstractCurve)compositeCurve);
		if (object != null)
			return object;

		if (compositeCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CompositeSolid compositeSolid) {
		T object = apply((AbstractSolid)compositeSolid);
		if (object != null)
			return object;

		if (compositeSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember())) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CompositeSurface compositeSurface) {
		T object = apply((AbstractSurface)compositeSurface);
		if (object != null)
			return object;

		if (compositeSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Curve curve) {
		return apply((AbstractCurve)curve);
	}

	public T apply(GeometricComplex geometricComplex) {
		T object = apply((AbstractGeometry)geometricComplex);
		if (object != null)
			return object;

		if (geometricComplex.isSetElement()) {
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement())) {
				object = apply(geometricPrimitiveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Grid grid) {
		return apply((AbstractGeometry)grid);
	}

	public T apply(LinearRing linearRing) {
		return apply((AbstractRing)linearRing);
	}

	public T apply(LineString lineString) {
		return apply((AbstractCurve)lineString);
	}

	public T apply(MultiCurve multiCurve) {
		T object = apply((AbstractGeometricAggregate)multiCurve);
		if (object != null)
			return object;

		if (multiCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		if (multiCurve.isSetCurveMembers()) {
			object = apply(multiCurve.getCurveMembers());
			if (object != null)
				return object;
		}

		return null;
	}
	
	public T apply(MultiGeometry multiGeometry) {
		T object = apply((AbstractGeometricAggregate)multiGeometry);
		if (object != null)
			return object;

		if (multiGeometry.isSetGeometryMember()) {
			for (GeometryProperty<? extends AbstractGeometry> geometryProperty : new ArrayList<GeometryProperty<? extends AbstractGeometry>>(multiGeometry.getGeometryMember())) {
				object = apply(geometryProperty);
				if (object != null)
					return object;
			}
		}

		if (multiGeometry.isSetGeometryMembers()) {
			object = apply(multiGeometry.getGeometryMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiLineString multiLineString) {
		T object = apply((AbstractGeometricAggregate)multiLineString);
		if (object != null)
			return object;

		if (multiLineString.isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember())) {
				object = apply(lineStringProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MultiPoint multiPoint) {
		T object = apply((AbstractGeometricAggregate)multiPoint);
		if (object != null)
			return object;

		if (multiPoint.isSetPointMember()) {
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember())) {
				object = apply(pointProperty);
				if (object != null)
					return object;
			}
		}

		if (multiPoint.isSetPointMembers()) {
			object = apply(multiPoint.getPointMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiPolygon multiPolygon) {
		T object = apply((AbstractGeometricAggregate)multiPolygon);
		if (object != null)
			return object;

		if (multiPolygon.isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember())) {
				object = apply(polygonProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MultiSolid multiSolid) {
		T object = apply((AbstractGeometricAggregate)multiSolid);
		if (object != null)
			return object;

		if (multiSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember())) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSolid.isSetSolidMembers()) {
			object = apply(multiSolid.getSolidMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiSurface multiSurface) {
		T object = apply((AbstractGeometricAggregate)multiSurface);
		if (object != null)
			return object;

		if (multiSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSurface.isSetSurfaceMembers()) {
			object = apply(multiSurface.getSurfaceMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(OrientableCurve orientableCurve) {
		T object = apply((AbstractCurve)orientableCurve);
		if (object != null)
			return object;

		if (orientableCurve.isSetBaseCurve()) {
			object = apply(orientableCurve.getBaseCurve());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(OrientableSurface orientableSurface) {
		T object = apply((AbstractSurface)orientableSurface);
		if (object != null)
			return object;

		if (orientableSurface.isSetBaseSurface()) {
			object = apply(orientableSurface.getBaseSurface());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(_TexturedSurface texturedSurface) {
		T object = apply((OrientableSurface)texturedSurface);
		if (object != null)
			return object;

		return null;
	}

	public T apply(Point point) {
		return apply((AbstractGeometricPrimitive)point);
	}

	public T apply(Polygon polygon) {
		T object = apply((AbstractSurface)polygon);
		if (object != null)
			return object;

		if (polygon.isSetExterior()) {
			object = apply(polygon.getExterior());
			if (object != null)
				return object;
		}

		if (polygon.isSetInterior()) {
			for (AbstractRingProperty abstractRingProperty : new ArrayList<AbstractRingProperty>(polygon.getInterior())) {
				object = apply(abstractRingProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RectifiedGrid rectifiedGrid) {
		T object = apply((Grid)rectifiedGrid);
		if (object != null)
			return object;

		if (rectifiedGrid.isSetOrigin()) {
			object = apply(rectifiedGrid.getOrigin());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Ring ring) {
		T object = apply((AbstractRing)ring);
		if (object != null)
			return object;

		if (ring.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Solid solid) {
		T object = apply((AbstractSolid)solid);
		if (object != null)
			return object;

		if (solid.isSetExterior()) {
			object = apply(solid.getExterior());
			if (object != null)
				return object;
		}

		if (solid.isSetInterior()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(solid.getInterior())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Surface surface) {
		T object = apply((AbstractSurface)surface);
		if (object != null)
			return object;

		if (surface.isSetPatches()) {
			object = apply(surface.getPatches());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Tin tin) {
		return apply((TriangulatedSurface)tin);
	}

	public T apply(TriangulatedSurface triangulatedSurface) {
		return apply((Surface)triangulatedSurface);
	}
	
	public T apply(ImplicitGeometry implicitGeometry) {
		// to be overridden in subclasses
		return null;
	}
	
	public <E extends AbstractGML> T apply(AssociationByRepOrRef<E> association) {
		if (shouldWalk) {
			if (association.getObject() instanceof AbstractGeometry) {
				T object = ((AbstractGeometry)association.getObject()).accept(this);
				if (object != null)
					return object;
			} else if (association.getObject() instanceof ImplicitGeometry) {
				T object = apply((ImplicitGeometry)association.getObject());
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public <E extends AbstractGeometry> T apply(GeometryProperty<E> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk) {
			T object = geometryProperty.getGeometry().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}

	public <E extends AbstractGeometry> T apply(InlineGeometryProperty<E> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk) {
			T object = geometryProperty.getGeometry().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}

	public <E extends AbstractGeometry> T apply(GeometryArrayProperty<E> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry())) {
				if (shouldWalk) {
					T object = abstractGeometry.accept(this);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public T apply(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		T object = null;

		if (surfacePatchArrayProperty.isSetSurfacePatch()) {
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk) {
					if (abstractSurfacePatch instanceof Triangle) {
						object = apply((Triangle)abstractSurfacePatch);
						if (object != null)
							return object;
					} else if (abstractSurfacePatch instanceof Rectangle) {
						object = apply((Rectangle)abstractSurfacePatch);
						if (object != null)
							return object;
					}
				}
			}
		}

		return null;
	}

}
