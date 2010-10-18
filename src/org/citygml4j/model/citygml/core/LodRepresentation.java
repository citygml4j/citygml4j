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
package org.citygml4j.model.citygml.core;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class LodRepresentation {
	private List<GeometryProperty<? extends AbstractGeometry>> lod0Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod1Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod2Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod3Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod4Geometry;

	public List<GeometryProperty<? extends AbstractGeometry>> getLod0Geometry() {
		if (lod0Geometry == null)
			lod0Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod0Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod1Geometry() {
		if (lod1Geometry == null)
			lod1Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod1Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod2Geometry() {
		if (lod2Geometry == null)
			lod2Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod2Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod3Geometry() {
		if (lod3Geometry == null)
			lod3Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod3Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod4Geometry() {
		if (lod4Geometry == null)
			lod4Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod4Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLodGeometry(int lod) {
		switch (lod) {
		case 0:
			return getLod0Geometry();
		case 1:
			return getLod1Geometry();
		case 2:
			return getLod2Geometry();
		case 3:
			return getLod3Geometry();
		case 4:
			return getLod4Geometry();
		default:
			return null;
		}
	}

	public boolean isSetLod0Geometry() {
		return lod0Geometry != null && !lod0Geometry.isEmpty();
	}

	public boolean isSetLod1Geometry() {
		return lod1Geometry != null && !lod1Geometry.isEmpty();
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null && !lod2Geometry.isEmpty();
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null && !lod3Geometry.isEmpty();
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null && !lod4Geometry.isEmpty();
	}

	public boolean isSetLodGeometry(int lod) {
		switch (lod) {
		case 0:
			return isSetLod0Geometry();
		case 1:
			return isSetLod1Geometry();
		case 2:
			return isSetLod2Geometry();
		case 3:
			return isSetLod3Geometry();
		case 4:
			return isSetLod4Geometry();
		default:
			return false;
		}
	}

}
