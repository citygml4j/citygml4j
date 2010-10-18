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
package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.grids.RectifiedGrid;

public class RectifiedGridDomainImpl extends DomainSetImpl<RectifiedGrid> implements RectifiedGridDomain {

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
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridDomain copy = (target == null) ? new RectifiedGridDomainImpl() : (RectifiedGridDomain)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridDomainImpl(), copyBuilder);
	}

}
