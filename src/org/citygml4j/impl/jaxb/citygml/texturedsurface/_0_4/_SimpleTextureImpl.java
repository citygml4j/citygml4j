package org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4;

import java.util.List;

import org.citygml4j.jaxb.citygml._0_4.SimpleTextureType;
import org.citygml4j.jaxb.citygml._0_4.TextureTypeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;

public class _SimpleTextureImpl extends _AppearanceImpl implements _SimpleTexture {
	private SimpleTextureType simpleTextureType;

	public _SimpleTextureImpl() {
		this(new SimpleTextureType());
	}

	public _SimpleTextureImpl(SimpleTextureType simpleTextureType) {
		super(simpleTextureType);
		this.simpleTextureType = simpleTextureType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._SIMPLETEXTURE;
	}

	@Override
	public SimpleTextureType getJAXBObject() {
		return simpleTextureType;
	}

	public Boolean getRepeat() {
		return simpleTextureType.isRepeat();
	}

	public List<Double> getTextureCoordinates() {
		return simpleTextureType.getTextureCoordinates();
	}

	public String getTextureMap() {
		return simpleTextureType.getTextureMap();
	}

	public _TextureType getTextureType() {
		if (simpleTextureType.isSetTextureType()) {
			_TextureType textureType = null;

			try {
				textureType = _TextureTypeImpl.fromValue(simpleTextureType.getTextureType().value());
			} catch (IllegalArgumentException e) {
				//
			}

			return textureType;
		}

		return null;
	}

	public void setRepeat(Boolean repeat) {
		simpleTextureType.setRepeat(repeat);
	}

	public void setTextureCoordinates(List<Double> textureCoordinates) {
		simpleTextureType.unsetTextureCoordinates();
		simpleTextureType.getTextureCoordinates().addAll(textureCoordinates);
	}

	public void setTextureMap(String textureMap) {
		simpleTextureType.setTextureMap(textureMap);
	}

	public void setTextureType(_TextureType textureType) {
		TextureTypeType textureTypeType = null;

		try {
			textureTypeType = TextureTypeType.fromValue(((_TextureTypeImpl)textureType).getValue());
		} catch (IllegalArgumentException e) {
			//
		}

		if (textureTypeType != null)
			simpleTextureType.setTextureType(textureTypeType);
	}

	public boolean isSetRepeat() {
		return simpleTextureType.isSetRepeat();
	}

	public boolean isSetTextureCoordinates() {
		return simpleTextureType.isSetTextureCoordinates();
	}

	public boolean isSetTextureMap() {
		return simpleTextureType.isSetTextureMap();
	}

	public boolean isSetTextureType() {
		return simpleTextureType.isSetTextureType();
	}

	public void unsetRepeat() {
		simpleTextureType.setRepeat(null);
	}

	public void unsetTextureType() {
		simpleTextureType.setTextureType(null);
	}

}
