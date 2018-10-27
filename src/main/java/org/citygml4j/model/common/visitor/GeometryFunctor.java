/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
	public T apply(LodRepresentation lodRepresentation);	
	public T apply(CompositeCurve compositeCurve);
	public T apply(CompositeSolid compositeSolid);
	public T apply(CompositeSurface compositeSurface);
	public T apply(Curve curve);
	public T apply(GeometricComplex geometricComplex);
	public T apply(Grid grid);
	public T apply(LinearRing linearRing);
	public T apply(LineString lineString);
	public T apply(MultiCurve multiCurve);
	public T apply(MultiLineString multiLineString);
	public T apply(MultiGeometry multiGeometry);
	public T apply(MultiPoint multiPoint);
	public T apply(MultiPolygon multiPolygon);
	public T apply(MultiSolid multiSolid);
	public T apply(MultiSurface multiSurface);
	public T apply(OrientableCurve orientableCurve);
	public T apply(OrientableSurface orientableSurface);
	public T apply(_TexturedSurface texturedSurface);
	public T apply(Point point);
	public T apply(Polygon polygon);
	public T apply(RectifiedGrid rectifiedGrid);
	public T apply(Ring ring);
	public T apply(Solid solid);
	public T apply(Surface surface);
	public T apply(Tin tin);
	public T apply(TriangulatedSurface triangulatedSurface);
}
