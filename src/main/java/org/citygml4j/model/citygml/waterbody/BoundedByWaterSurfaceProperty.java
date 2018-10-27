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
package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class BoundedByWaterSurfaceProperty extends FeatureProperty<AbstractWaterBoundarySurface> implements WaterBodyModuleComponent {
	private WaterBodyModule module;
	
	public BoundedByWaterSurfaceProperty() {
		
	}
	
	public BoundedByWaterSurfaceProperty(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		super(abstractWaterBoundarySurface);
	}
	
	public BoundedByWaterSurfaceProperty(String href) {
		super(href);
	}
	
	public BoundedByWaterSurfaceProperty(WaterBodyModule module) {
		this.module = module;
	}
	
	public AbstractWaterBoundarySurface getWaterBoundarySurface() {
		return super.getObject();
	}

	public boolean isSetWaterBoundarySurface() {
		return super.isSetObject();
	}

	public void setWaterBoundarySurface(AbstractWaterBoundarySurface waterBoundarySurface) {
		super.setObject(waterBoundarySurface);
	}

	public void unsetWaterBoundarySurface() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BOUNDED_BY_WATER_SURFACE_PROPERTY;
	}

	public final WaterBodyModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractWaterBoundarySurface> getAssociableClass() {
		return AbstractWaterBoundarySurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundedByWaterSurfaceProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundedByWaterSurfaceProperty copy = (target == null) ? new BoundedByWaterSurfaceProperty() : (BoundedByWaterSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
