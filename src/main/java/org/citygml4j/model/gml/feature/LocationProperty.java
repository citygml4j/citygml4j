/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObjects;
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
		this.locationKeyWord = ModelObjects.setParent(locationKeyWord, this);
	}

	public void setLocationString(StringOrRef locationString) {
		this.locationString = ModelObjects.setParent(locationString, this);
	}

	public void setNull(Null _null) {
		this._null = ModelObjects.setParent(_null, this);
	}

	public void unsetLocationKeyWord() {
		locationKeyWord = ModelObjects.setNull(locationKeyWord);
	}

	public void unsetLocationString() {
		locationString = ModelObjects.setNull(locationString);
	}

	public void unsetNull() {
		_null = ModelObjects.setNull(_null);
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
