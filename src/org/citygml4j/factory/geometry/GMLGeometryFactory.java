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
package org.citygml4j.factory.geometry;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.impl.gml.geometry.primitives.DirectPositionImpl;
import org.citygml4j.impl.gml.geometry.primitives.DirectPositionListImpl;
import org.citygml4j.impl.gml.geometry.primitives.ExteriorImpl;
import org.citygml4j.impl.gml.geometry.primitives.InteriorImpl;
import org.citygml4j.impl.gml.geometry.primitives.LineStringImpl;
import org.citygml4j.impl.gml.geometry.primitives.LinearRingImpl;
import org.citygml4j.impl.gml.geometry.primitives.PointImpl;
import org.citygml4j.impl.gml.geometry.primitives.PolygonImpl;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.Exterior;
import org.citygml4j.model.gml.geometry.primitives.Interior;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.Polygon;

public class GMLGeometryFactory {

	public GMLGeometryFactory() {

	}
	
	public Point createPoint(List<Double> coordinates, int dim) throws DimensionMismatchException {
		Point point = new Point();
		point.setPos(createDirectPosition(coordinates, dim));
		
		return point;
	}
	
	public Point createPoint(double[] coordinates, int dim) throws DimensionMismatchException {
		return createPoint(asList(coordinates), dim);
	}

	public LineString createLineString(List<Double> coordinates, int dim) throws DimensionMismatchException {
		LineString lineString = new LineString();
		lineString.setPosList(createDirectPositionList(coordinates, dim));

		return lineString;
	}

	public LineString createLineString(double[] coordinates, int dim) throws DimensionMismatchException {
		return createLineString(asList(coordinates), dim);
	}

	public Polygon createLinearPolygon(List<Double> coords, int dim) throws DimensionMismatchException {
		Polygon polygon = new Polygon();

		Exterior exterior = new Exterior();
		exterior.setRing(createLinearRing(coords, dim));		
		polygon.setExterior(exterior);

		return polygon;
	}
	
	public Polygon createLinearPolygon(double[] coordinates, int dim) throws DimensionMismatchException {
		return createLinearPolygon(asList(coordinates), dim);
	}

	public Polygon createLinearPolygon(Object[] coordinates, int dim) throws DimensionMismatchException {
		Polygon polygon = null;
		List<List<Double>> coordList = asList(coordinates);

		if (coordList.size() > 0) {
			polygon = createLinearPolygon(coordList.get(0), dim);

			for (int i = 1; i < coordList.size(); i++) {
				LinearRing linearRing = createLinearRing(coordList.get(i), dim);
				Interior interior = new Interior();
				interior.setRing(linearRing);

				polygon.addInterior(interior);
			}
		}

		return polygon;
	}
	
	public Polygon createLinearPolygon(double[][] coordinates, int dim) throws DimensionMismatchException {
		Polygon polygon = null;
		
		if (coordinates.length > 0) {
			polygon = createLinearPolygon(coordinates[0], dim);
			
			for (int i = 1; i < coordinates.length; i++) {
				LinearRing linearRing = createLinearRing(coordinates[i], dim);
				Interior interior = new Interior();
				interior.setRing(linearRing);

				polygon.addInterior(interior);
			}
		}
		
		return polygon;
	}
	
	public DirectPosition createDirectPosition(List<Double> coordinates, int dim) throws DimensionMismatchException {
		if (coordinates.size() != dim)
			throw new DimensionMismatchException();
		
		DirectPosition pos = new DirectPosition();
		pos.setValue(coordinates);
		pos.setSrsDimension(dim);
		
		return pos;
	}
	
	public DirectPosition createDirectPosition(double[] coordinates, int dim) throws DimensionMismatchException {
		return createDirectPosition(asList(coordinates), dim);
	}
	
	public DirectPositionList createDirectPositionList(List<Double> coordinates, int dim) throws DimensionMismatchException {
		if ((coordinates.size() % dim) != 0)
			throw new DimensionMismatchException();

		DirectPositionList posList = new DirectPositionList();
		posList.setValue(coordinates);
		posList.setSrsDimension(dim);
		
		return posList;
	}
	
	public DirectPositionList createDirectPositionList(double[] coordinates, int dim) throws DimensionMismatchException {
		return createDirectPositionList(asList(coordinates), dim);
	}	
	
	public LinearRing createLinearRing(List<Double> coordinates, int dim) throws DimensionMismatchException {
		DirectPositionList posList = createDirectPositionList(coordinates, dim);
		
		boolean addCoord = false;
		for (int i = 0; !addCoord && i < dim; i++)
			if (coordinates.get(i) != coordinates.get(coordinates.size() - dim))
				addCoord = true;

		if (addCoord)
			for (int i = 0; i < dim; i++)
				coordinates.add(coordinates.get(i));

		LinearRing linearRing = new LinearRing();
		linearRing.setPosList(posList);

		return linearRing;
	}
	
	public LinearRing createLinearRing(double[] coordinates, int dim) throws DimensionMismatchException {
		return createLinearRing(asList(coordinates), dim);
	}
	
	@SuppressWarnings("unchecked")
	private List<List<Double>> asList(Object[] array) {
		List<List<Double>> list = new ArrayList<List<Double>>(array.length);
		boolean isValid = true;
		
		for (int i = 0; isValid && i < array.length; i++) {
			if (array[i] instanceof List<?>) {
				boolean isDoubleList = true;

				for (Object item : (List<?>)array[i]) {
					if (!(item instanceof Double)) {
						isDoubleList = false;
						break;
					}
				}

				if (isDoubleList)
					list.add((List<Double>)array[i]);
				else 
					isValid = false;
			}

			else if (array[i] instanceof double[])
				list.add(asList((double[])array[i]));

			else
				isValid = false;
		}
		
		return list;
	}
	
	private List<Double> asList(double[] array) {
		List<Double> list = new ArrayList<Double>(array.length);
		for (double item : array)
			list.add(item);

		return list;
	}
}
