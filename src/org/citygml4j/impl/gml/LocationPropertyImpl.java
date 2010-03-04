package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.Null;
import org.citygml4j.model.gml.StringOrRef;

public class LocationPropertyImpl implements LocationProperty {
	private AbstractGeometry geometry;
	private Code locationKeyWord;
	private StringOrRef locationString;
	private Null _null;
	private String actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private String show;
	private String title;
	private String type;
	private Object parent;
	
	public AbstractGeometry getGeometry() {
		return geometry;
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

	public boolean isSetGeometry() {
		return geometry != null;
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

	public void setGeometry(AbstractGeometry geometry) {
		if (geometry != null)
			geometry.setParent(this);
		
		this.geometry = geometry;
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

	public void unsetGeometry() {
		if (isSetGeometry())
			geometry.unsetParent();
		
		geometry = null;
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
		return GMLClass.LOCATIONPROPERTY;
	}

	public String getActuate() {
		return actuate;
	}

	public String getArcrole() {
		return arcrole;
	}

	public String getHref() {
		return href;
	}

	public String getRemoteSchema() {
		return remoteSchema;
	}

	public String getRole() {
		return role;
	}

	public String getShow() {
		return show;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		if (type == null)
			return "simple";
		else
			return type;
	}

	public boolean isSetActuate() {
		return actuate != null;
	}

	public boolean isSetArcrole() {
		return arcrole != null;
	}

	public boolean isSetHref() {
		return href != null;
	}

	public boolean isSetRemoteSchema() {
		return remoteSchema != null;
	}

	public boolean isSetRole() {
		return role != null;
	}

	public boolean isSetShow() {
		return show != null;
	}

	public boolean isSetTitle() {
		return title != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setActuate(String actuate) {
		this.actuate = actuate;
	}

	public void setArcrole(String arcrole) {
		this.arcrole = arcrole;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setRemoteSchema(String remoteSchema) {
		this.remoteSchema = remoteSchema;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = "simple";
	}

	public void unsetActuate() {
		actuate = null;
	}

	public void unsetArcrole() {
		arcrole = null;
	}

	public void unsetHref() {
		href = null;
	}

	public void unsetRemoteSchema() {
		remoteSchema = null;
	}

	public void unsetRole() {
		role = null;
	}

	public void unsetShow() {
		show = null;
	}

	public void unsetTitle() {
		title = null;
	}

	public void unsetType() {
		type = null;
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LocationPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LocationProperty copy = (target == null) ? new LocationPropertyImpl() : (LocationProperty)target;
		
		if (isSetGeometry()) {
			copy.setGeometry((AbstractGeometry)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
		}
		
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
		
		if (isSetActuate())
			copy.setActuate(copyBuilder.copy(actuate));

		if (isSetArcrole())
			copy.setArcrole(copyBuilder.copy(arcrole));
		
		if (isSetHref())
			copy.setHref(copyBuilder.copy(href));
		
		if (isSetRemoteSchema())
			copy.setRemoteSchema(copyBuilder.copy(remoteSchema));
		
		if (isSetRole())
			copy.setRole(copyBuilder.copy(role));
		
		if (isSetShow())
			copy.setShow(copyBuilder.copy(show));

		if (isSetTitle())
			copy.setTitle(copyBuilder.copy(title));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		copy.unsetParent();
		
		return copy;
	}

}
