/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class ParameterizedTextureImpl extends AbstractTextureImpl implements ParameterizedTexture {
	private List<TextureAssociation> target;
	private List<ADEComponent> ade;
	
	public ParameterizedTextureImpl() {
		
	}
	
	public ParameterizedTextureImpl(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addTarget(TextureAssociation target) {
		if (this.target == null)
			this.target = new ChildList<TextureAssociation>(this);

		this.target.add(target);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfParameterizedTexture() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<TextureAssociation> getTarget() {
		if (target == null)
			target = new ChildList<TextureAssociation>(this);

		return target;
	}

	public boolean isSetGenericApplicationPropertyOfParameterizedTexture() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetTarget() {
		return target != null && !target.isEmpty();
	}

	public void setGenericApplicationPropertyOfParameterizedTexture(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setTarget(List<TextureAssociation> target) {
		this.target = new ChildList<TextureAssociation>(this, target);
	}

	public void unsetGenericApplicationPropertyOfParameterizedTexture() {
		if (isSetGenericApplicationPropertyOfParameterizedTexture())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfParameterizedTexture() ? this.ade.remove(ade) : false;
	}

	public void unsetTarget() {
		if (isSetTarget())
			target.clear();

		target = null;
	}

	public boolean unsetTarget(TextureAssociation target) {
		return isSetTarget() ? this.target.remove(target) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PARAMETERIZED_TEXTURE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ParameterizedTextureImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ParameterizedTexture copy = (target == null) ? new ParameterizedTextureImpl() : (ParameterizedTexture)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTarget()) {
			for (TextureAssociation part : this.target) {
				TextureAssociation copyPart = (TextureAssociation)copyBuilder.copy(part);
				copy.addTarget(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfParameterizedTexture(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
