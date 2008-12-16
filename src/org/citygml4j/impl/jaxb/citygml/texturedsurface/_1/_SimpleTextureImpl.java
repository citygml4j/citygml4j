package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import java.util.List;

import org.citygml4j.jaxb.citygml.tex._1.SimpleTextureType;
import org.citygml4j.jaxb.citygml.tex._1.TextureTypeType;
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

	@Override
	public Boolean getRepeat() {
		return simpleTextureType.isRepeat();
	}

	@Override
	public List<Double> getTextureCoordinates() {
		return simpleTextureType.getTextureCoordinates();
	}

	@Override
	public String getTextureMap() {
		return simpleTextureType.getTextureMap();
	}

	@Override
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

	@Override
	public void setRepeat(Boolean repeat) {
		simpleTextureType.setRepeat(repeat);
	}

	@Override
	public void setTextureCoordinates(List<Double> textureCoordinates) {
		simpleTextureType.unsetTextureCoordinates();
		simpleTextureType.getTextureCoordinates().addAll(textureCoordinates);
	}

	@Override
	public void setTextureMap(String textureMap) {
		simpleTextureType.setTextureMap(textureMap);
	}

	@Override
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

	@Override
	public boolean isSetRepeat() {
		return simpleTextureType.isSetRepeat();
	}

	@Override
	public boolean isSetTextureCoordinates() {
		return simpleTextureType.isSetTextureCoordinates();
	}

	@Override
	public boolean isSetTextureMap() {
		return simpleTextureType.isSetTextureMap();
	}

	@Override
	public boolean isSetTextureType() {
		return simpleTextureType.isSetTextureType();
	}

	@Override
	public void unsetRepeat() {
		simpleTextureType.setRepeat(null);
	}

	@Override
	public void unsetTextureType() {
		simpleTextureType.setTextureType(null);
	}
}
