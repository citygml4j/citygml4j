/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public abstract class _AbstractAppearance extends AbstractGML implements TexturedSurfaceModuleComponent {
	private TexturedSurfaceModule module;

	public _AbstractAppearance() {
		
	}
	
	public _AbstractAppearance(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
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
