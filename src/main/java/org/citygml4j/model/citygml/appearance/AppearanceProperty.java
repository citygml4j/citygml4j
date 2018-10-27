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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearanceProperty extends FeatureProperty<Appearance> implements AppearanceModuleComponent {
	private AppearanceModule module;
	
	public AppearanceProperty() {

	}
	
	public AppearanceProperty(Appearance appearance) {
		super(appearance);
	}
	
	public AppearanceProperty(String href) {
		super(href);
	}
	
	public AppearanceProperty(AppearanceModule module) {
		this.module = module;
	}
	
	public Appearance getAppearance() {
		return super.getFeature();
	}

	public boolean isSetAppearance() {
		return super.isSetFeature();
	}

	public void setAppearance(Appearance appearance) {
		super.setFeature(appearance);
	}

	public void unsetAppearance() {
		super.unsetFeature();
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE_PROPERTY;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<Appearance> getAssociableClass() {
		return Appearance.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AppearanceProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AppearanceProperty copy = (target == null) ? new AppearanceProperty() : (AppearanceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
