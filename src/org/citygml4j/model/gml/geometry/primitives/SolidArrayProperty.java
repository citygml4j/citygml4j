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
 * $Id: SolidArrayProperty.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public class SolidArrayProperty extends GeometryArrayProperty<AbstractSolid> {

	public SolidArrayProperty() {

	}

	public SolidArrayProperty(AbstractSolid abstractSolid) {
		super(abstractSolid);
	}

	public SolidArrayProperty(List<AbstractSolid> abstractSolid) {
		super(abstractSolid);
	}
	
	public SolidArrayProperty(AbstractSolid... abstractSolid) {
		super(abstractSolid);
	}
	
	public void addSolid(AbstractSolid abstractSolid) {
		super.addGeometry(abstractSolid);
	}

	public List<? extends AbstractSolid> getSolid() {
		return super.getGeometry();
	}

	public boolean isSetSolid() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setSolid(List<? extends AbstractSolid> abstractSolid) {
		super.setGeometry((List<AbstractSolid>)abstractSolid);
	}

	public void unsetSolid() {
		super.unsetGeometry();
	}

	public boolean unsetSolid(AbstractSolid abstractSolid) {
		return super.unsetGeometry(abstractSolid);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.SOLID_ARRAY_PROPERTY;
	}

	public Class<AbstractSolid> getAssociableClass() {
		return AbstractSolid.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidArrayProperty copy = (target == null) ? new SolidArrayProperty() : (SolidArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
