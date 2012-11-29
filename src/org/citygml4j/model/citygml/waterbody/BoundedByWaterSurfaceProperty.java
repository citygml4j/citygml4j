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
package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
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

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
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
