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
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class TunnelPartProperty extends FeatureProperty<TunnelPart> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public TunnelPartProperty() {
		
	}
	
	public TunnelPartProperty(TunnelPart tunnelPart) {
		super(tunnelPart);
	}
	
	public TunnelPartProperty(String href) {
		super(href);
	}
	
	public TunnelPartProperty(TunnelModule module) {
		this.module = module;
	}
	
	public TunnelPart getTunnelPart() {
		return super.getObject();
	}

	public boolean isSetTunnelPart() {
		return super.isSetObject();
	}

	public void setTunnelPart(TunnelPart tunnelPart) {
		super.setObject(tunnelPart);
	}

	public void unsetTunnelPart() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_PART_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TunnelPart> getAssociableClass() {
		return TunnelPart.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TunnelPartProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TunnelPartProperty copy = (target == null) ? new TunnelPartProperty() : (TunnelPartProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
