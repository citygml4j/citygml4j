/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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

public interface GeometryVisitor extends Visitor {
	public void visit(LodRepresentation lodRepresentation);
	public void visit(CompositeCurve compositeCurve);
	public void visit(CompositeSolid compositeSolid);
	public void visit(CompositeSurface compositeSurface);
	public void visit(Curve curve);
	public void visit(GeometricComplex geometricComplex);
	public void visit(Grid grid);
	public void visit(LinearRing linearRing);
	public void visit(LineString lineString);
	public void visit(MultiCurve multiCurve);
	public void visit(MultiLineString multiLineString);
	public void visit(MultiGeometry multiGeometry);
	public void visit(MultiPoint multiPoint);
	public void visit(MultiPolygon multiPolygon);
	public void visit(MultiSolid multiSolid);
	public void visit(MultiSurface multiSurface);
	public void visit(OrientableCurve orientableCurve);
	public void visit(OrientableSurface orientableSurface);
	public void visit(_TexturedSurface texturedSurface);
	public void visit(Point point);
	public void visit(Polygon polygon);
	public void visit(RectifiedGrid rectifiedGrid);
	public void visit(Ring ring);
	public void visit(Solid solid);
	public void visit(Surface surface);
	public void visit(Tin tin);
	public void visit(TriangulatedSurface triangulatedSurface);
}
