package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.tex._1.AbstractAppearanceType;
import org.citygml4j.jaxb.citygml.tex._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.tex._1.MaterialType;
import org.citygml4j.jaxb.citygml.tex._1.SimpleTextureType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;

public class _AppearancePropertyImpl extends CityGMLBaseImpl implements _AppearanceProperty {
	private AppearancePropertyType _appearancePropertyType;

	public _AppearancePropertyImpl() {
		_appearancePropertyType = new AppearancePropertyType();
	}

	public _AppearancePropertyImpl(AppearancePropertyType _appearancePropertyType) {
		this._appearancePropertyType = _appearancePropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCEPROPERTY;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return TexturedSurfaceModule.v1_0_0;
	}

	@Override
	public AppearancePropertyType getJAXBObject() {
		return _appearancePropertyType;
	}

	@Override
	public _Appearance getAppearance() {
		if (_appearancePropertyType.isSet_Appearance()) {
			JAXBElement<? extends AbstractAppearanceType> jaxbElem = _appearancePropertyType.get_Appearance();

			if (jaxbElem.getValue() != null) {
				if (jaxbElem.getValue() instanceof MaterialType)
					return new _MaterialImpl((MaterialType)jaxbElem.getValue());
				else if (jaxbElem.getValue() instanceof SimpleTextureType)
					return new _SimpleTextureImpl((SimpleTextureType)jaxbElem.getValue());
			}
		}

		return null;
	}

	@Override
	public String getOrientation() {
		return _appearancePropertyType.getOrientation();
	}

	@Override
	public void setAppearance(_Appearance _appearance) {
		JAXBElement<? extends AbstractAppearanceType> elem = null;

		switch (_appearance.getCityGMLClass()) {
		case _MATERIAL:
			elem = ObjectFactory.TEX_1.createMaterial(((_MaterialImpl)_appearance).getJAXBObject());
			break;
		case _SIMPLETEXTURE:
			elem = ObjectFactory.TEX_1.createSimpleTexture(((_SimpleTextureImpl)_appearance).getJAXBObject());
			break;
		}

		if (elem != null)
			_appearancePropertyType.set_Appearance(elem);
	}

	@Override
	public void setOrientation(String orientation) {
		_appearancePropertyType.setOrientation(orientation);
	}

	@Override
	public String getActuate() {
		return _appearancePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return _appearancePropertyType.getActuate();
	}

	@Override
	public String getHref() {
		return _appearancePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return _appearancePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return _appearancePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return _appearancePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return _appearancePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return _appearancePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		_appearancePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		_appearancePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		_appearancePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		_appearancePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		_appearancePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		_appearancePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		_appearancePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		_appearancePropertyType.setType(type);
	}

	@Override
	public boolean isSetAppearance() {
		return _appearancePropertyType.isSet_Appearance();
	}

	@Override
	public boolean isSetOrientation() {
		return _appearancePropertyType.isSetOrientation();
	}

	@Override
	public void unsetAppearance() {
		_appearancePropertyType.set_Appearance(null);
	}
	
	@Override
	public boolean isSetActuate() {
		return _appearancePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return _appearancePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return _appearancePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return _appearancePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return _appearancePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return _appearancePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return _appearancePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return _appearancePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		_appearancePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		_appearancePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		_appearancePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		_appearancePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		_appearancePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		_appearancePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		_appearancePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		_appearancePropertyType.setType(null);
	}
}
