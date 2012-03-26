/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
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
