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
