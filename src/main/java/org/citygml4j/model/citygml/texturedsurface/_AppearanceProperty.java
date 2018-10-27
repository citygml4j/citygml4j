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
package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.geometry.primitives.Sign;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _AppearanceProperty extends AssociationByRepOrRef<_AbstractAppearance> implements TexturedSurfaceModuleComponent {
	private Sign orientation;
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

	public Sign getOrientation() {
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

	public void setOrientation(Sign orientation) {
		this.orientation = orientation;
	}

	public void unsetAppearance() {
		super.unsetObject();
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
			copy.setOrientation((Sign)copyBuilder.copy(orientation));
		
        return copy;
	}

}
