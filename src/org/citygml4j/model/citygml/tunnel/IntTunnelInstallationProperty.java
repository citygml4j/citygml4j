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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: IntTunnelInstallationProperty.java 539 2012-11-29 20:34:56Z nagel $
 */
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class IntTunnelInstallationProperty extends FeatureProperty<IntTunnelInstallation> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public IntTunnelInstallationProperty() {
		
	}
	
	public IntTunnelInstallationProperty(IntTunnelInstallation intTunnelInstallation) {
		super(intTunnelInstallation);
	}
	
	public IntTunnelInstallationProperty(String href) {
		super(href);
	}
	
	public IntTunnelInstallationProperty(TunnelModule module) {
		this.module = module;
	}
	
	public IntTunnelInstallation getIntTunnelInstallation() {
		return super.getObject();
	}

	public boolean isSetIntTunnelInstallation() {
		return super.isSetObject();
	}

	public void setIntTunnelInstallation(IntTunnelInstallation intTunnelInstallation) {
		super.setObject(intTunnelInstallation);
	}

	public void unsetIntTunnelInstallation() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_TUNNEL_INSTALLATION_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<IntTunnelInstallation> getAssociableClass() {
		return IntTunnelInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntTunnelInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntTunnelInstallationProperty copy = (target == null) ? new IntTunnelInstallationProperty() : (IntTunnelInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
