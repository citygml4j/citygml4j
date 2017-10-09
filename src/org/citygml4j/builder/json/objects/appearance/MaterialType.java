package org.citygml4j.builder.json.objects.appearance;

import java.util.List;
import java.util.Objects;

public class MaterialType {
	private String name;
	private Double ambientIntensity;
	private List<Double> diffuseColor;
	private List<Double> emissiveColor;
	private List<Double> specularColor;
	private Double shininess;
	private Double transparency;
	private Boolean isSmooth;

	public boolean isSetName() {
		return name != null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSetAmbientIntensity() {
		return ambientIntensity != null;
	}

	public Double getAmbientIntensity() {
		return ambientIntensity;
	}

	public void setAmbientIntensity(Double ambientIntensity) {
		if (ambientIntensity == null
				|| (ambientIntensity >= 0 && ambientIntensity <= 1))
			this.ambientIntensity = ambientIntensity;
	}

	public boolean isSetDiffuseColor() {
		return diffuseColor != null && diffuseColor.size() >= 3;
	}

	public List<Double> getDiffuseColor() {
		return isSetDiffuseColor() ? diffuseColor.subList(0, 3) : null;
	}

	public void setDiffuseColor(List<Double> diffuseColor) {
		if (diffuseColor == null)
			this.diffuseColor = null;
		else if (diffuseColor.size() >= 3)
			this.diffuseColor = diffuseColor.subList(0, 3);
	}

	public boolean isSetEmissiveColor() {
		return emissiveColor != null && emissiveColor.size() >= 3;
	}

	public List<Double> getEmissiveColor() {
		return isSetEmissiveColor() ? emissiveColor.subList(0, 3) : null;
	}

	public void setEmissiveColor(List<Double> emissiveColor) {
		if (emissiveColor == null)
			this.emissiveColor = null;
		else if (emissiveColor.size() >= 3)
			this.emissiveColor = emissiveColor.subList(0, 3);
	}

	public boolean isSetSpecularColor() {
		return specularColor != null && specularColor.size() >= 3;
	}

	public List<Double> getSpecularColor() {
		return isSetSpecularColor() ? specularColor.subList(0, 3) : null;
	}

	public void setSpecularColor(List<Double> specularColor) {
		if (specularColor == null)
			this.specularColor = null;
		else if (specularColor.size() >= 3)
			this.specularColor = specularColor.subList(0, 3);
	}

	public boolean isSetShininess() {
		return shininess != null;
	}

	public Double getShininess() {
		return shininess;
	}

	public void setShininess(Double shininess) {
		if (shininess == null
				|| (shininess >= 0 && shininess <= 1))
			this.shininess = shininess;
	}

	public boolean isSetTransparency() {
		return transparency != null;
	}

	public Double getTransparency() {
		return transparency;
	}

	public void setTransparency(Double transparency) {
		if (transparency == null
				|| (transparency >= 0 && transparency <= 1))
			this.transparency = transparency;
	}

	public boolean isSmooth() {
		return isSmooth != null && isSmooth.booleanValue();
	}

	public void setIsSmooth(Boolean isSmooth) {
		this.isSmooth = isSmooth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, ambientIntensity, diffuseColor, emissiveColor, specularColor, shininess, transparency, isSmooth);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (!(obj instanceof MaterialType))
			return false;

		MaterialType other = (MaterialType)obj;
		return Objects.equals(name, other.name)
				&& Objects.equals(ambientIntensity, other.ambientIntensity)
				&& Objects.equals(diffuseColor, other.diffuseColor)
				&& Objects.equals(emissiveColor, other.emissiveColor)
				&& Objects.equals(specularColor, other.specularColor)
				&& Objects.equals(shininess, other.shininess)
				&& Objects.equals(transparency, other.transparency)
				&& Objects.equals(isSmooth, other.isSmooth);
	}

}
