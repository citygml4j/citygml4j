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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class GridProperty extends FeatureProperty<RectifiedGridCoverage> implements ReliefModuleComponent {
	private ReliefModule module;
	
	public GridProperty() {
		
	}
	
	public GridProperty(RectifiedGridCoverage rectifiedGridCoverage) {
		super(rectifiedGridCoverage);
	}
	
	public GridProperty(String href) {
		super(href);
	}
	
	public GridProperty(ReliefModule module) {
		this.module = module;
	}
	
	public RectifiedGridCoverage getRectifiedGridCoverage() {
		return super.getObject();
	}

	public boolean isSetRectifiedGridCoverage() {
		return super.isSetObject();
	}

	public void setRectifiedGridCoverage(RectifiedGridCoverage rectifiedGridCoverage) {
		super.setObject(rectifiedGridCoverage);
	}

	public void unsetRectifiedGridCoverage() {
		super.unsetObject();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GRID_PROPERTY;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	@Override
	public Class<RectifiedGridCoverage> getAssociableClass() {
		return RectifiedGridCoverage.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridProperty copy = (target == null) ? new GridProperty() : (GridProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridProperty(), copyBuilder);
	}

}
