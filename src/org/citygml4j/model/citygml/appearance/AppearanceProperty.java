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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
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
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
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
