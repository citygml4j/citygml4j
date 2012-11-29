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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: _AbstractAppearance.java 542 2012-11-29 20:56:44Z nagel $
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
