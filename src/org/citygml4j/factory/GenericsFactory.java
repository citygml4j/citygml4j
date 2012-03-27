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
package org.citygml4j.factory;

import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.MeasureAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;

public class GenericsFactory {

	public GenericsFactory() {
		
	}

	public GenericCityObject createGenericCityObject() {
		return new GenericCityObject();
	}

	public DateAttribute createDateAttribute() {
		return new DateAttribute();
	}

	public DoubleAttribute createDoubleAttribute() {
		return new DoubleAttribute();
	}

	public IntAttribute createIntAttribute() {
		return new IntAttribute();
	}

	public StringAttribute createStringAttribute() {
		return new StringAttribute();
	}

	public UriAttribute createUriAttribute() {
		return new UriAttribute();
	}
	
	public MeasureAttribute createMeasureAttribute() {
		return new MeasureAttribute();
	}
	
	public GenericAttributeSet createGenericAttributeSet() {
		return new GenericAttributeSet();
	}

}
