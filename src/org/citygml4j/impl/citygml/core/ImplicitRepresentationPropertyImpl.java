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
package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitRepresentationPropertyImpl extends AssociationByRepOrRefImpl<ImplicitGeometry> implements ImplicitRepresentationProperty {
	private CoreModule module;
	
	public ImplicitRepresentationPropertyImpl() {
		
	}
	
	public ImplicitRepresentationPropertyImpl(CoreModule module) {
		this.module = module;
	}
	
	public ImplicitGeometry getImplicitGeometry() {
		return super.getObject();
	}

	public boolean isSetImplicitGeometry() {
		return super.isSetObject();
	}

	public void setImplicitGeometry(ImplicitGeometry implicitGeometry) {
		super.setObject(implicitGeometry);
	}

	public void unsetImplicitGeometry() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICIT_REPRESENTATION_PROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public Class<ImplicitGeometry> getAssociableClass() {
		return ImplicitGeometry.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ImplicitRepresentationPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitRepresentationProperty copy = (target == null) ? new ImplicitRepresentationPropertyImpl() : (ImplicitRepresentationProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
