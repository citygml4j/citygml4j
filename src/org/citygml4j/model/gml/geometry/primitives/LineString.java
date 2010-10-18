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

import org.citygml4j.model.gml.basicTypes.Coordinates;

public interface LineString extends AbstractCurve {
	public List<PosOrPointPropertyOrPointRepOrCoord> getPosOrPointPropertyOrPointRepOrCoord();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public boolean isSetPosOrPointPropertyOrPointRepOrCoord();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void addCoord(Coord coord);	
	public void addControlPoint(PosOrPointPropertyOrPointRepOrCoord controlPoint);
	public void setPosOrPointPropertyOrPointRepOrCoord(List<PosOrPointPropertyOrPointRepOrCoord> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void unsetPosOrPointPropertyOrPointRepOrCoord();
	public boolean unsetPosOrPointPropertyOrPointRepOrCoord(PosOrPointPropertyOrPointRepOrCoord posOrPointPropertyOrPointRepOrCoord);
	public boolean unsetPointProperty(PointProperty pointProperty);
	public boolean unsetPointRep(PointRep pointRep);
	public boolean unsetPos(DirectPosition pos);
	public boolean unsetCoord(Coord coord);
	public void unsetPosList();
	public void unsetCoordinates();
}
