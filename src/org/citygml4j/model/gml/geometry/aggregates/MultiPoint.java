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
package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public interface MultiPoint extends AbstractGeometricAggregate {
	public List<PointProperty> getPointMember();
	public PointArrayProperty getPointMembers();
	public boolean isSetPointMember();
	public boolean isSetPointMembers();
	
	public void addPointMember(PointProperty pointMember);
	public void setPointMember(List<PointProperty> pointMember);
	public void setPointMembers(PointArrayProperty pointMembers);
	public void unsetPointMember();
	public boolean unsetPointMember(PointProperty pointMember);
	public void unsetPointMembers();
}
