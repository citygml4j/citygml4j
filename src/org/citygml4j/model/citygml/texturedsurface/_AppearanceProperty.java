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
package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _AppearanceProperty extends AssociationByRepOrRef<_AbstractAppearance> implements TexturedSurfaceModuleComponent {
	private String orientation;
	private TexturedSurfaceModule module;
	
	public _AppearanceProperty() {
		
	}
	
	public _AppearanceProperty(_AbstractAppearance _abstractAppearance) {
		super(_abstractAppearance);
	}
	
	public _AppearanceProperty(String href) {
		super(href);
	}
	
	public _AppearanceProperty(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public _AbstractAppearance getAppearance() {
		return super.getObject();
	}

	public String getOrientation() {
		return orientation;
	}

	public boolean isSetAppearance() {
		return super.isSetObject();
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setAppearance(_AbstractAppearance _appearance) {
		super.setObject(_appearance);
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void unsetAppearance() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCE_PROPERTY;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Class<_AbstractAppearance> getAssociableClass() {
		return _AbstractAppearance.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _AppearanceProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_AppearanceProperty copy = (target == null) ? new _AppearanceProperty() : (_AppearanceProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetOrientation())
			copy.setOrientation(copyBuilder.copy(orientation));
		
        return copy;
	}

}
