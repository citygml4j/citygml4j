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
package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AbstractGMLImpl;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public abstract class _AbstractAppearanceImpl extends AbstractGMLImpl implements _AbstractAppearance {
	private TexturedSurfaceModule module;

	public _AbstractAppearanceImpl() {
		
	}
	
	public _AbstractAppearanceImpl(TexturedSurfaceModule module) {
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
