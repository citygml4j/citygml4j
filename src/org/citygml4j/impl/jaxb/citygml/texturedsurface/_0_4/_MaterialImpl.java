package org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4;

import java.util.List;

import org.citygml4j.jaxb.citygml._0_4.MaterialType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;

public class _MaterialImpl extends _AppearanceImpl implements _Material {
	private MaterialType materialType;

	public _MaterialImpl() {
		this(new MaterialType());
	}

	public _MaterialImpl(MaterialType materialType) {
		super(materialType);
		this.materialType = materialType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._MATERIAL;
	}

	@Override
	public MaterialType getJAXBObject() {
		return materialType;
	}

	@Override
	public Double getAmbientIntensity() {
		return materialType.getAmbientIntensity();
	}

	@Override
	public _Color getDiffuseColor() {
		if (materialType.isSetDiffuseColor()) {
			_Color diffuseColor = new _ColorImpl(0.8);
			List<Double> diffuseColorList = materialType.getDiffuseColor();

			if (diffuseColorList.size() >= 3) {
				diffuseColor.setRed(diffuseColorList.get(0));
				diffuseColor.setGreen(diffuseColorList.get(1));
				diffuseColor.setBlue(diffuseColorList.get(2));
			}

			return diffuseColor;
		}

		return null;
	}

	@Override
	public _Color getEmissiveColor() {
		if (materialType.isSetEmissiveColor()) {
			_Color emissiveColor = new _ColorImpl(0.0);
			List<Double> emissiveColorList = materialType.getEmissiveColor();

			if (emissiveColorList.size() >= 3) {
				emissiveColor.setRed(emissiveColorList.get(0));
				emissiveColor.setGreen(emissiveColorList.get(1));
				emissiveColor.setBlue(emissiveColorList.get(2));
			}

			return emissiveColor;
		}

		return null;
	}

	@Override
	public Double getShininess() {
		return materialType.getShininess();
	}

	@Override
	public _Color getSpecularColor() {
		if (materialType.isSetSpecularColor()) {
			_Color specularColor = new _ColorImpl(1.0);
			List<Double> specularColorList = materialType.getSpecularColor();

			if (specularColorList.size() >= 3) {
				specularColor.setRed(specularColorList.get(0));
				specularColor.setGreen(specularColorList.get(1));
				specularColor.setBlue(specularColorList.get(2));
			}

			return specularColor;
		}

		return null;
	}

	@Override
	public Double getTransparency() {
		return materialType.getTransparency();
	}

	@Override
	public void setAmbientIntensity(Double ambientIntensity) {
		if (ambientIntensity >= 0.0 && ambientIntensity <= 1.0)
			materialType.setAmbientIntensity(ambientIntensity);
		else
			materialType.setAmbientIntensity(0.0);
	}

	@Override
	public void setDiffuseColor(_Color diffuseColor) {
		materialType.unsetDiffuseColor();
		materialType.getDiffuseColor().addAll(diffuseColor.toList());
	}

	@Override
	public void setEmissiveColor(_Color emissiveColor) {
		materialType.unsetEmissiveColor();
		materialType.getEmissiveColor().addAll(emissiveColor.toList());
	}

	@Override
	public void setShininess(Double shininess) {
		if (shininess >= 0.0 && shininess <= 1.0)
			materialType.setShininess(shininess);
		else
			materialType.setShininess(0.0);
	}

	@Override
	public void setSpecularColor(_Color specularColor) {
		materialType.unsetSpecularColor();
		materialType.getSpecularColor().addAll(specularColor.toList());
	}

	@Override
	public void setTransparency(Double transparency) {
		if (transparency >= 0.0 && transparency <= 1.0)
			materialType.setTransparency(transparency);
		else
			materialType.setTransparency(0.0);
	}

	@Override
	public boolean isSetAmbientIntensity() {
		return materialType.isSetAmbientIntensity();
	}

	@Override
	public boolean isSetDiffuseColor() {
		return materialType.isSetDiffuseColor();
	}

	@Override
	public boolean isSetEmissiveColor() {
		return materialType.isSetEmissiveColor();
	}

	@Override
	public boolean isSetShininess() {
		return materialType.isSetShininess();
	}

	@Override
	public boolean isSetSpecularColor() {
		return materialType.isSetSpecularColor();
	}

	@Override
	public boolean isSetTransparency() {
		return materialType.isSetTransparency();
	}

	@Override
	public void unsetAmbientIntensity() {
		materialType.setAmbientIntensity(null);
	}

	@Override
	public void unsetDiffuseColor() {
		materialType.unsetDiffuseColor();
	}

	@Override
	public void unsetEmissiveColor() {
		materialType.unsetEmissiveColor();
	}

	@Override
	public void unsetShininess() {
		materialType.setShininess(null);
	}

	@Override
	public void unsetSpecularColor() {
		materialType.unsetSpecularColor();
	}

	@Override
	public void unsetTransparency() {
		materialType.setTransparency(null);
	}

}
