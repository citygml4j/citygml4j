package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.List;

import org.citygml4j.impl.jaxb.citygml.core._0_4.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml._0_4.TexCoordListType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;

public class TextureCoordinatesImpl extends CityGMLBaseImpl implements TextureCoordinates {
	private TexCoordListType.TextureCoordinates textureCoordinates;

	public TextureCoordinatesImpl() {
		this.textureCoordinates = new TexCoordListType.TextureCoordinates();
	}

	public TextureCoordinatesImpl(TexCoordListType.TextureCoordinates textureCoordinates) {
		this.textureCoordinates = textureCoordinates;
	}

	@Override
	public TexCoordListType.TextureCoordinates getJAXBObject() {
		return textureCoordinates;
	}

	public void addValue(Double value) {
		textureCoordinates.getValue().add(value);
	}

	public String getRing() {
		return textureCoordinates.getRing();
	}

	public List<Double> getValue() {
		return textureCoordinates.getValue();
	}

	public void setRing(String ring) {
		textureCoordinates.setRing(ring);
	}

	public void setValue(List<Double> value) {
		textureCoordinates.unsetValue();
		textureCoordinates.getValue().addAll(value);
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURECOORDINATES;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	public boolean isSetRing() {
		return textureCoordinates.isSetRing();
	}

	public boolean isSetValue() {
		return textureCoordinates.isSetValue();
	}

	public void unsetRing() {
		textureCoordinates.setRing(null);
	}

	public void unsetValue() {
		textureCoordinates.unsetValue();
	}

}
