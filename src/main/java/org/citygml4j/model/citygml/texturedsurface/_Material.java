/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _Material extends _AbstractAppearance {
	private Double shininess;
	private Double transparency;
	private Double ambientIntensity;
	private _Color diffuseColor;
	private _Color emissiveColor;
	private _Color specularColor;
	
	public _Material() {
		
	}
	
	public _Material(TexturedSurfaceModule module) {
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

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._MATERIAL;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _Material(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_Material copy = (target == null) ? new _Material() : (_Material)target;
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
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
