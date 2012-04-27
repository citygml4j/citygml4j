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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class LocationProperty extends GeometryProperty<AbstractGeometry> {
	private Code locationKeyWord;
	private StringOrRef locationString;
	private Null _null;
	
	public LocationProperty() {

	}

	public LocationProperty(AbstractGeometry abstractGeometry) {
		super(abstractGeometry);
	}

	public LocationProperty(String href) {
		super(href);
	}
	
	public Code getLocationKeyWord() {
		return locationKeyWord;
	}

	public StringOrRef getLocationString() {
		return locationString;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetLocationKeyWord() {
		return locationKeyWord != null;
	}

	public boolean isSetLocationString() {
		return locationString != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setLocationKeyWord(Code locationKeyWord) {
		if (locationKeyWord != null)
			locationKeyWord.setParent(this);
		
		this.locationKeyWord = locationKeyWord;
	}

	public void setLocationString(StringOrRef locationString) {
		if (locationString != null)
			locationString.setParent(this);
		
		this.locationString = locationString;
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
	}

	public void unsetLocationKeyWord() {
		if (isSetLocationKeyWord())
			locationKeyWord.unsetParent();
		
		locationKeyWord = null;
	}

	public void unsetLocationString() {
		if (isSetLocationString())
			locationString.unsetParent();
		
		locationString = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();
		
		_null = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.LOCATION_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LocationProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LocationProperty copy = (target == null) ? new LocationProperty() : (LocationProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLocationKeyWord()) {
			copy.setLocationKeyWord((Code)copyBuilder.copy(locationKeyWord));
			if (copy.getLocationKeyWord() == locationKeyWord)
				locationKeyWord.setParent(this);
		}
		
		if (isSetLocationString()) {
			copy.setLocationString((StringOrRef)copyBuilder.copy(locationString));
			if (copy.getLocationString() == locationString)
				locationString.setParent(this);
		}
		
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		return copy;
	}

}
