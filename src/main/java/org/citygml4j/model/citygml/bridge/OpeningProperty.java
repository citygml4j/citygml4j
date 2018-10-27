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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BridgeModule;

public class OpeningProperty extends FeatureProperty<AbstractOpening> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public OpeningProperty() {
		
	}
	
	public OpeningProperty(AbstractOpening abstractOpening) {
		super(abstractOpening);
	}
	
	public OpeningProperty(String href) {
		super(href);
	}
	
	public OpeningProperty(BridgeModule module) {
		this.module = module;
	}
	
	public AbstractOpening getOpening() {
		return (AbstractOpening)super.getObject();
	}

	public boolean isSetOpening() {
		return super.isSetObject();
	}

	public void setOpening(AbstractOpening opening) {
		super.setObject(opening);
	}

	public void unsetOpening() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BRIDGE_OPENING_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractOpening> getAssociableClass() {
		return AbstractOpening.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OpeningProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OpeningProperty copy = (target == null) ? new OpeningProperty() : (OpeningProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
