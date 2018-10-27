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
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class TunnelInstallationProperty extends FeatureProperty<TunnelInstallation> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public TunnelInstallationProperty() {
		
	}
	
	public TunnelInstallationProperty(TunnelInstallation tunnelInstallation) {
		super(tunnelInstallation);
	}
	
	public TunnelInstallationProperty(String href) {
		super(href);
	}
	
	public TunnelInstallationProperty(TunnelModule module) {
		this.module = module;
	}
	
	public TunnelInstallation getTunnelInstallation() {
		return super.getObject();
	}

	public boolean isSetTunnelInstallation() {
		return super.isSetObject();
	}

	public void setTunnelInstallation(TunnelInstallation tunnelInstallation) {
		super.setObject(tunnelInstallation);
	}

	public void unsetTunnelInstallation() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_INSTALLATION_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TunnelInstallation> getAssociableClass() {
		return TunnelInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TunnelInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TunnelInstallationProperty copy = (target == null) ? new TunnelInstallationProperty() : (TunnelInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
