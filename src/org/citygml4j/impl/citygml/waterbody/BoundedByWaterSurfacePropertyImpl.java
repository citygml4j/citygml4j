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
package org.citygml4j.impl.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class BoundedByWaterSurfacePropertyImpl extends FeaturePropertyImpl<AbstractWaterBoundarySurface> implements BoundedByWaterSurfaceProperty {
	private WaterBodyModule module;
	
	public BoundedByWaterSurfacePropertyImpl() {
		
	}
	
	public BoundedByWaterSurfacePropertyImpl(WaterBodyModule module) {
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
		return copyTo(new BoundedByWaterSurfacePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundedByWaterSurfaceProperty copy = (target == null) ? new BoundedByWaterSurfacePropertyImpl() : (BoundedByWaterSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
