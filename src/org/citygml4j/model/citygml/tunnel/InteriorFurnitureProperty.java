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
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class InteriorFurnitureProperty extends FeatureProperty<TunnelFurniture> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public InteriorFurnitureProperty() {
		
	}
	
	public InteriorFurnitureProperty(TunnelFurniture tunnelFurniture) {
		super(tunnelFurniture);
	}
	
	public InteriorFurnitureProperty(String href) {
		super(href);
	}
	
	public InteriorFurnitureProperty(TunnelModule module) {
		this.module = module;
	}
	
	public TunnelFurniture getTunnelFurniture() {
		return super.getObject();
	}

	public boolean isSetTunnelFurniture() {
		return super.isSetObject();
	}

	public void setTunnelFurniture(TunnelFurniture tunnelFurniture) {
		super.setObject(tunnelFurniture);
	}

	public void unsetTunnelFurniture() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_TUNNEL_FURNITURE_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TunnelFurniture> getAssociableClass() {
		return TunnelFurniture.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorFurnitureProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorFurnitureProperty copy = (target == null) ? new InteriorFurnitureProperty() : (InteriorFurnitureProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
