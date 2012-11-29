/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * 
 * $Id$
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.grids.RectifiedGrid;

public class RectifiedGridDomain extends DomainSet<RectifiedGrid> {

	public RectifiedGridDomain() {

	}

	public RectifiedGridDomain(RectifiedGrid rectifiedGrid) {
		super(rectifiedGrid);
	}

	public RectifiedGridDomain(String href) {
		super(href);
	}
	
	public RectifiedGrid getRectifiedGrid() {
		return super.getGeometry();
	}

	public boolean isSetRectifiedGrid() {
		return super.isSetGeometry();
	}

	public void setRectifiedGrid(RectifiedGrid rectifiedGrid) {
		setObject(rectifiedGrid);
	}

	public void unsetRectifiedGrid() {
		super.unsetGeometry();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID_DOMAIN;
	}

	@Override
	public Class<RectifiedGrid> getAssociableClass() {
		return RectifiedGrid.class;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridDomain copy = (target == null) ? new RectifiedGridDomain() : (RectifiedGridDomain)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridDomain(), copyBuilder);
	}

}
