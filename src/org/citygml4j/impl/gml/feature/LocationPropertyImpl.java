package org.citygml4j.impl.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class LocationPropertyImpl extends GeometryPropertyImpl<AbstractGeometry> implements LocationProperty {
	private Code locationKeyWord;
	private StringOrRef locationString;
	private Null _null;
	
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
		return copyTo(new LocationPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LocationProperty copy = (target == null) ? new LocationPropertyImpl() : (LocationProperty)target;
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
