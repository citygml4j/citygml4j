/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;

import java.util.List;

public class _TexturedSurface extends OrientableSurface implements TexturedSurfaceModuleComponent {
	private List<_AppearanceProperty> appearance;
	
	public void addAppearance(_AppearanceProperty appearance) {
		getAppearance().add(appearance);
	}

	public List<_AppearanceProperty> getAppearance() {
		if (appearance == null)
			appearance = new ChildList<>(this);

		return appearance;
	}

	public boolean isSetAppearance() {
		return appearance != null && !appearance.isEmpty();
	}

	public void setAppearance(List<_AppearanceProperty> appearance) {
		this.appearance = new ChildList<>(this, appearance);
	}

	public void unsetAppearance() {
		appearance = ModelObjects.setNull(appearance);
	}

	public boolean unsetAppearance(_AppearanceProperty appearance) {
		return isSetAppearance() && this.appearance.remove(appearance);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass._TEXTURED_SURFACE;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._TEXTURED_SURFACE;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _TexturedSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_TexturedSurface copy = (target == null) ? new _TexturedSurface() : (_TexturedSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAppearance()) {
			for (_AppearanceProperty part : appearance) {
				_AppearanceProperty copyPart = (_AppearanceProperty)copyBuilder.copy(part);
				copy.addAppearance(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

	@Override
	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}	

}
