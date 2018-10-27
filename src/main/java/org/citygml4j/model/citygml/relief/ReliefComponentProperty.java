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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class ReliefComponentProperty extends FeatureProperty<AbstractReliefComponent> implements ReliefModuleComponent {
	private ReliefModule module;
	
	public ReliefComponentProperty() {
		
	}
	
	public ReliefComponentProperty(AbstractReliefComponent abstractReliefComponent) {
		super(abstractReliefComponent);
	}
	
	public ReliefComponentProperty(String href) {
		super(href);
	}
	
	public ReliefComponentProperty(ReliefModule module) {
		this.module = module;
	}
	
	public AbstractReliefComponent getReliefComponent() {
		return super.getObject();
	}

	public boolean isSetReliefComponent() {
		return super.isSetObject();
	}

	public void setReliefComponent(AbstractReliefComponent reliefComponent) {
		super.setObject(reliefComponent);
	}

	public void unsetReliefComponent() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEF_COMPONENT_PROPERTY;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractReliefComponent> getAssociableClass() {
		return AbstractReliefComponent.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ReliefComponentProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ReliefComponentProperty copy = (target == null) ? new ReliefComponentProperty() : (ReliefComponentProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
