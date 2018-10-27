/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
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
