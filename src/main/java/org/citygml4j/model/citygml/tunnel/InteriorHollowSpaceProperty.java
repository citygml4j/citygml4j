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

public class InteriorHollowSpaceProperty extends FeatureProperty<HollowSpace> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public InteriorHollowSpaceProperty() {
		
	}
	
	public InteriorHollowSpaceProperty(HollowSpace hollowSpace) {
		super(hollowSpace);
	}
	
	public InteriorHollowSpaceProperty(String href) {
		super(href);
	}
	
	public InteriorHollowSpaceProperty(TunnelModule module) {
		this.module = module;
	}
	
	public HollowSpace getHollowSpace() {
		return super.getObject();
	}

	public boolean isSetHollowSpace() {
		return super.isSetObject();
	}

	public void setHollowSpace(HollowSpace hollowSpace) {
		super.setObject(hollowSpace);
	}

	public void unsetHollowSpace() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_HOLLOW_SPACE_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<HollowSpace> getAssociableClass() {
		return HollowSpace.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorHollowSpaceProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorHollowSpaceProperty copy = (target == null) ? new InteriorHollowSpaceProperty() : (InteriorHollowSpaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
