/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BridgeModule;

public class BoundarySurfaceProperty extends FeatureProperty<AbstractBoundarySurface> implements BridgeModuleComponent {
	private BridgeModule module;

	public BoundarySurfaceProperty() {
		
	}
	
	public BoundarySurfaceProperty(AbstractBoundarySurface abstractBoundarySurface) {
		super(abstractBoundarySurface);
	}
	
	public BoundarySurfaceProperty(String href) {
		super(href);
	}
	
	public BoundarySurfaceProperty(BridgeModule module) {
		this.module = module;
	}
	
	public AbstractBoundarySurface getBoundarySurface() {
		return super.getObject();
	}

	public boolean isSetBoundarySurface() {
		return super.isSetObject();
	}

	public void setBoundarySurface(AbstractBoundarySurface boundarySurface) {
		super.setObject(boundarySurface);
	}

	public void unsetBoundarySurface() {
		super.unsetObject();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BRIDGE_BOUNDARY_SURFACE_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractBoundarySurface> getAssociableClass() {
		return AbstractBoundarySurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BoundarySurfaceProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BoundarySurfaceProperty copy = (target == null) ? new BoundarySurfaceProperty() : (BoundarySurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
