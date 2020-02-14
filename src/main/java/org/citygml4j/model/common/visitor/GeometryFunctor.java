/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
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
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.RectifiedGrid;

public interface GeometryFunctor<T> extends Functor<T> {
	T apply(LodRepresentation lodRepresentation);	
	T apply(CompositeCurve compositeCurve);
	T apply(CompositeSolid compositeSolid);
	T apply(CompositeSurface compositeSurface);
	T apply(Curve curve);
	T apply(GeometricComplex geometricComplex);
	T apply(Grid grid);
	T apply(LinearRing linearRing);
	T apply(LineString lineString);
	T apply(MultiCurve multiCurve);
	T apply(MultiLineString multiLineString);
	T apply(MultiGeometry multiGeometry);
	T apply(MultiPoint multiPoint);
	T apply(MultiPolygon multiPolygon);
	T apply(MultiSolid multiSolid);
	T apply(MultiSurface multiSurface);
	T apply(OrientableCurve orientableCurve);
	T apply(OrientableSurface orientableSurface);
	T apply(_TexturedSurface texturedSurface);
	T apply(Point point);
	T apply(Polygon polygon);
	T apply(RectifiedGrid rectifiedGrid);
	T apply(Ring ring);
	T apply(Solid solid);
	T apply(Surface surface);
	T apply(Tin tin);
	T apply(TriangulatedSurface triangulatedSurface);
}
