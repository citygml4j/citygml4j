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
package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;

public class SurfacePatchArrayPropertyImpl extends ArrayAssociationImpl<AbstractSurfacePatch> implements SurfacePatchArrayProperty {
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		super.addObject(surfacePatch);
	}

	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		return super.getObject();
	}

	public boolean isSetSurfacePatch() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		super.setObject((List<AbstractSurfacePatch>)surfacePatch);
	}

	public void unsetSurfacePatch() {
		super.unsetObject();
	}

	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		return super.unsetObject(surfacePatch);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Class<AbstractSurfacePatch> getAssociableClass() {
		return AbstractSurfacePatch.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfacePatchArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfacePatchArrayProperty copy = (target == null) ? new SurfacePatchArrayPropertyImpl() : (SurfacePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
