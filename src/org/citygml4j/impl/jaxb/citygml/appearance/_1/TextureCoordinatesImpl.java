package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.util.List;

import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.app._1.TexCoordListType;
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

	@Override
	public void addValue(Double value) {
		textureCoordinates.getValue().add(value);
	}

	@Override
	public String getRing() {
		return textureCoordinates.getRing();
	}

	@Override
	public List<Double> getValue() {
		return textureCoordinates.getValue();
	}

	@Override
	public void setRing(String ring) {
		textureCoordinates.setRing(ring);
	}

	@Override
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
		return AppearanceModule.v1_0_0;
	}

	@Override
	public boolean isSetRing() {
		return textureCoordinates.isSetRing();
	}

	@Override
	public boolean isSetValue() {
		return textureCoordinates.isSetValue();
	}

	@Override
	public void unsetRing() {
		textureCoordinates.setRing(null);
	}

	@Override
	public void unsetValue() {
		textureCoordinates.unsetValue();
	}
}
