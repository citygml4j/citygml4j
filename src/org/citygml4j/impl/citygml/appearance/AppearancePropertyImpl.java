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
package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearancePropertyImpl extends FeaturePropertyImpl<Appearance> implements AppearanceProperty {
	private AppearanceModule module;
	
	public AppearancePropertyImpl() {

	}
	
	public AppearancePropertyImpl(AppearanceModule module) {
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
		return copyTo(new AppearancePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AppearanceProperty copy = (target == null) ? new AppearancePropertyImpl() : (AppearanceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
