package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import java.util.List;

import org.citygml4j.jaxb.citygml.tex._1.MaterialType;
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

	public Double getAmbientIntensity() {
		return materialType.getAmbientIntensity();
	}

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

	public Double getShininess() {
		return materialType.getShininess();
	}

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

	public Double getTransparency() {
		return materialType.getTransparency();
	}

	public void setAmbientIntensity(Double ambientIntensity) {
		if (ambientIntensity >= 0.0 && ambientIntensity <= 1.0)
			materialType.setAmbientIntensity(ambientIntensity);
		else
			materialType.setAmbientIntensity(0.0);
	}

	public void setDiffuseColor(_Color diffuseColor) {
		materialType.unsetDiffuseColor();
		materialType.getDiffuseColor().addAll(diffuseColor.toList());
	}

	public void setEmissiveColor(_Color emissiveColor) {
		materialType.unsetEmissiveColor();
		materialType.getEmissiveColor().addAll(emissiveColor.toList());
	}

	public void setShininess(Double shininess) {
		if (shininess >= 0.0 && shininess <= 1.0)
			materialType.setShininess(shininess);
		else
			materialType.setShininess(0.0);
	}

	public void setSpecularColor(_Color specularColor) {
		materialType.unsetSpecularColor();
		materialType.getSpecularColor().addAll(specularColor.toList());
	}

	public void setTransparency(Double transparency) {
		if (transparency >= 0.0 && transparency <= 1.0)
			materialType.setTransparency(transparency);
		else
			materialType.setTransparency(0.0);
	}

	public boolean isSetAmbientIntensity() {
		return materialType.isSetAmbientIntensity();
	}

	public boolean isSetDiffuseColor() {
		return materialType.isSetDiffuseColor();
	}

	public boolean isSetEmissiveColor() {
		return materialType.isSetEmissiveColor();
	}

	public boolean isSetShininess() {
		return materialType.isSetShininess();
	}

	public boolean isSetSpecularColor() {
		return materialType.isSetSpecularColor();
	}

	public boolean isSetTransparency() {
		return materialType.isSetTransparency();
	}

	public void unsetAmbientIntensity() {
		materialType.setAmbientIntensity(null);
	}

	public void unsetDiffuseColor() {
		materialType.unsetDiffuseColor();
	}

	public void unsetEmissiveColor() {
		materialType.unsetEmissiveColor();
	}

	public void unsetShininess() {
		materialType.setShininess(null);
	}

	public void unsetSpecularColor() {
		materialType.unsetSpecularColor();
	}

	public void unsetTransparency() {
		materialType.setTransparency(null);
	}
}
