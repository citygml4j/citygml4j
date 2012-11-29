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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.module.citygml.ReliefModule;

public class TinProperty extends GeometryProperty<TriangulatedSurface> implements ReliefModuleComponent {
	private ReliefModule module;
	
	public TinProperty() {
		
	}

	public TinProperty(TriangulatedSurface triangulatedSurface) {
		super(triangulatedSurface);
	}

	public TinProperty(String href) {
		super(href);
	}
	
	public TinProperty(ReliefModule module) {
		this.module = module;
	}
	
	public TriangulatedSurface getTriangulatedSurface() {
		return super.getObject();
	}

	public boolean isSetTriangulatedSurface() {
		return super.isSetObject();
	}

	public void setTriangulatedSurface(TriangulatedSurface triangulatedSurface) {
		super.setObject(triangulatedSurface);
	}

	public void unsetTriangulatedSurface() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TIN_PROPERTY;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TriangulatedSurface> getAssociableClass() {
		return TriangulatedSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TinProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TinProperty copy = (target == null) ? new TinProperty() : (TinProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
