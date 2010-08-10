package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;

public class _MaterialImpl extends _AbstractAppearanceImpl implements _Material {
	private Double shininess;
	private Double transparency;
	private Double ambientIntensity;
	private _Color diffuseColor;
	private _Color emissiveColor;
	private _Color specularColor;
	
	public _MaterialImpl() {
		
	}
	
	public _MaterialImpl(TexturedSurfaceModule module) {
		super(module);
	}
	
	public Double getAmbientIntensity() {
		return ambientIntensity;
	}

	public _Color getDiffuseColor() {
		return diffuseColor;
	}

	public _Color getEmissiveColor() {
		return emissiveColor;
	}

	public Double getShininess() {
		return shininess;
	}

	public _Color getSpecularColor() {
		return specularColor;
	}

	public Double getTransparency() {
		return transparency;
	}

	public boolean isSetAmbientIntensity() {
		return ambientIntensity != null;
	}

	public boolean isSetDiffuseColor() {
		return diffuseColor != null;
	}

	public boolean isSetEmissiveColor() {
		return emissiveColor != null;
	}

	public boolean isSetShininess() {
		return shininess != null;
	}

	public boolean isSetSpecularColor() {
		return specularColor != null;
	}

	public boolean isSetTransparency() {
		return transparency != null;
	}

	public void setAmbientIntensity(Double ambientIntensity) {
		this.ambientIntensity = ambientIntensity;
	}

	public void setDiffuseColor(_Color diffuseColor) {
		if (diffuseColor != null)
			diffuseColor.setParent(this);
		
		this.diffuseColor = diffuseColor;
	}

	public void setEmissiveColor(_Color emissiveColor) {
		if (emissiveColor != null)
			emissiveColor.setParent(this);
		
		this.emissiveColor = emissiveColor;
	}

	public void setShininess(Double shininess) {
		this.shininess = shininess;
	}

	public void setSpecularColor(_Color specularColor) {
		if (specularColor != null)
			specularColor.setParent(this);
		
		this.specularColor = specularColor;
	}

	public void setTransparency(Double transparency) {
		this.transparency = transparency;
	}

	public void unsetAmbientIntensity() {
		ambientIntensity = null;
	}

	public void unsetDiffuseColor() {
		if (isSetDiffuseColor())
			diffuseColor.unsetParent();
		
		diffuseColor = null;
	}

	public void unsetEmissiveColor() {
		if (isSetEmissiveColor())
			emissiveColor.unsetParent();
		
		emissiveColor = null;
	}

	public void unsetShininess() {
		shininess = null;
	}

	public void unsetSpecularColor() {
		if (isSetSpecularColor())
			specularColor.unsetParent();
		
		specularColor = null;
	}

	public void unsetTransparency() {
		transparency = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._MATERIAL;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _MaterialImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_Material copy = (target == null) ? new _MaterialImpl() : (_Material)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAmbientIntensity())
			copy.setAmbientIntensity((Double)copyBuilder.copy(ambientIntensity));
		
		if (isSetShininess())
			copy.setShininess((Double)copyBuilder.copy(shininess));
		
		if (isSetTransparency())
			copy.setTransparency((Double)copyBuilder.copy(transparency));
		
		if (isSetDiffuseColor()) {
			copy.setDiffuseColor((_Color)copyBuilder.copy(diffuseColor));
			if (copy.getDiffuseColor() == diffuseColor)
				diffuseColor.setParent(this);
		}
		
		if (isSetEmissiveColor()) {
			copy.setEmissiveColor((_Color)copyBuilder.copy(emissiveColor));
			if (copy.getEmissiveColor() == emissiveColor)
				emissiveColor.setParent(this);
		}
		
		if (isSetSpecularColor()) {
			copy.setSpecularColor((_Color)copyBuilder.copy(specularColor));
			if (copy.getSpecularColor() == specularColor)
				specularColor.setParent(this);
		}
		
		return copy;
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
