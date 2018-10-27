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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class SurfaceDataProperty extends FeatureProperty<AbstractSurfaceData> implements AppearanceModuleComponent {
	private AppearanceModule module;
	
	public SurfaceDataProperty() {
		
	}
	
	public SurfaceDataProperty(AbstractSurfaceData abstractSurfaceData) {
		super(abstractSurfaceData);
	}
	
	public SurfaceDataProperty(String href) {
		super(href);
	}
	
	public SurfaceDataProperty(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractSurfaceData getSurfaceData() {
		return super.getObject();
	}

	public boolean isSetSurfaceData() {
		return super.isSetObject();
	}

	public void setSurfaceData(AbstractSurfaceData surfaceData) {
		super.setObject(surfaceData);
	}
	
	public void unsetSurfaceData() {
		super.unsetObject();
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SURFACE_DATA_PROPERTY;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractSurfaceData> getAssociableClass() {
		return AbstractSurfaceData.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceDataProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceDataProperty copy = (target == null) ? new SurfaceDataProperty() : (SurfaceDataProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
