/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;

public interface Envelope extends SRSReferenceGroup, Child, Copyable {
	public DirectPosition getLowerCorner();
	public DirectPosition getUpperCorner();
	public List<Coord> getCoord();
	public List<DirectPosition> getPos();
	public Coordinates getCoordinates();
	public boolean isSetLowerCorner();
	public boolean isSetUpperCorner();
	public boolean isSetCoord();
	public boolean isSetPos();
	public boolean isSetCoordinates();
	
	public BoundingBox toBoundingBox();
	public Envelope convert3d();
	
	public void addCoord(Coord coord);
	public void addPos(DirectPosition pos);
	public void setLowerCorner(DirectPosition lowerCorner);
	public void setLowerCorner(Point lowerCorner);
	public void setUpperCorner(DirectPosition upperCorner);
	public void setUpperCorner(Point upperCorner);
	public void setCoord(List<Coord> coord);
	public void setPos(List<DirectPosition> pos);
	public void setCoordinates(Coordinates coordinates);
	public void unsetLowerCorner();
	public void unsetUpperCorner();
	public void unsetPos();
	public void unsetCoord();
	public boolean unsetCoord(Coord coord);
	public boolean unsetPos(DirectPosition pos);
	public void unsetCoordinates();
}
