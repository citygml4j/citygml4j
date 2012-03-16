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

import org.citygml4j.impl.citygml.generics.DateAttributeImpl;
import org.citygml4j.impl.citygml.generics.DoubleAttributeImpl;
import org.citygml4j.impl.citygml.generics.GenericAttributeSetImpl;
import org.citygml4j.impl.citygml.generics.GenericCityObjectImpl;
import org.citygml4j.impl.citygml.generics.IntAttributeImpl;
import org.citygml4j.impl.citygml.generics.MeasureAttributeImpl;
import org.citygml4j.impl.citygml.generics.StringAttributeImpl;
import org.citygml4j.impl.citygml.generics.UriAttributeImpl;
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
		return new GenericCityObjectImpl();
	}

	public DateAttribute createDateAttribute() {
		return new DateAttributeImpl();
	}

	public DoubleAttribute createDoubleAttribute() {
		return new DoubleAttributeImpl();
	}

	public IntAttribute createIntAttribute() {
		return new IntAttributeImpl();
	}

	public StringAttribute createStringAttribute() {
		return new StringAttributeImpl();
	}

	public UriAttribute createUriAttribute() {
		return new UriAttributeImpl();
	}
	
	public MeasureAttribute createMeasureAttribute() {
		return new MeasureAttributeImpl();
	}
	
	public GenericAttributeSet createGenericAttributeSet() {
		return new GenericAttributeSetImpl();
	}

}
