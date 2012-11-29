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
 * $Id: ImplicitRepresentationProperty.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitRepresentationProperty extends AssociationByRepOrRef<ImplicitGeometry> implements CoreModuleComponent {
	private CoreModule module;
	
	public ImplicitRepresentationProperty() {
		
	}
	
	public ImplicitRepresentationProperty(ImplicitGeometry implicitGeometry) {
		super(implicitGeometry);
	}
	
	public ImplicitRepresentationProperty(String href) {
		super(href);
	}
	
	public ImplicitRepresentationProperty(CoreModule module) {
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
		return copyTo(new ImplicitRepresentationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitRepresentationProperty copy = (target == null) ? new ImplicitRepresentationProperty() : (ImplicitRepresentationProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
