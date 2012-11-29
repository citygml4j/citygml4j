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
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearanceMember extends AppearanceProperty {

	public AppearanceMember() {
		
	}
	
	public AppearanceMember(Appearance appearance) {
		super(appearance);
	}
	
	public AppearanceMember(String href) {
		super(href);
	}
	
	public AppearanceMember(AppearanceModule module) {
		super(module);
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE_MEMBER;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AppearanceMember(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AppearanceMember copy = (target == null) ? new AppearanceMember() : (AppearanceMember)target;
		return super.copyTo(copy, copyBuilder);
	}

}
