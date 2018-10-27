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
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public abstract class _AbstractAppearance extends AbstractGML implements TexturedSurfaceModuleComponent {
	private TexturedSurfaceModule module;

	public _AbstractAppearance() {
		
	}
	
	public _AbstractAppearance(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		_AbstractAppearance copy = (_AbstractAppearance)target;		
		return super.copyTo(copy, copyBuilder);
	}

}
