package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _AppearancePropertyImpl implements _AppearanceProperty {
	private _Appearance _appearance;
	private String orientation;
	private String actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private String show;
	private String title;
	private String type;
	private TexturedSurfaceModule module;
	private Object parent;
	
	public _AppearancePropertyImpl() {
		
	}
	
	public _AppearancePropertyImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public _Appearance getAppearance() {
		return _appearance;
	}

	public String getOrientation() {
		return orientation;
	}

	public boolean isSetAppearance() {
		return _appearance != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setAppearance(_Appearance _appearance) {
		if (_appearance != null)
			_appearance.setParent(this);
		
		this._appearance = _appearance;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void unsetAppearance() {
		if (isSetAppearance())
			_appearance.unsetParent();
		
		_appearance = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCEPROPERTY;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
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

	public GMLClass getGMLClass() {
		return GMLClass.CITYGMLCLASS;
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
		return copyTo(new _AppearancePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_AppearanceProperty copy = (target == null) ? new _AppearancePropertyImpl() : (_AppearanceProperty)target;
		
		if (isSetAppearance()) {
			copy.setAppearance((_Appearance)copyBuilder.copy(_appearance));
			if (copy.getAppearance() == _appearance)
				_appearance.setParent(this);
		}
		
		if (isSetOrientation())
			copy.setOrientation(copyBuilder.copy(orientation));
		
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
