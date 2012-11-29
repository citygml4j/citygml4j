/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.appearance;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class GeoreferencedTexture extends AbstractTexture {
	private Boolean preferWorldFile;
	private PointProperty referencePoint;
	private TransformationMatrix2x2 orientation;
	private List<String> target;
	private List<ADEComponent> ade;

	public GeoreferencedTexture() {
		
	}
	
	public GeoreferencedTexture(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfGeoreferencedTexture(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addTarget(String target) {
		if (this.target == null)
			this.target = new ArrayList<String>();

		this.target.add(target);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfGeoreferencedTexture() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public TransformationMatrix2x2 getOrientation() {
		return orientation;
	}

	public Boolean getPreferWorldFile() {
		if (!isSetPreferWorldFile())
			return true;
		else
			return preferWorldFile;
	}

	public PointProperty getReferencePoint() {
		return referencePoint;
	}

	public List<String> getTarget() {
		if (target == null)
			target = new ArrayList<String>();

		return target;
	}

	public boolean isSetGenericApplicationPropertyOfGeoreferencedTexture() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public boolean isSetPreferWorldFile() {
		return preferWorldFile != null;
	}

	public boolean isSetReferencePoint() {
		return referencePoint != null;
	}

	public boolean isSetTarget() {
		return target != null && !target.isEmpty();
	}

	public void setGenericApplicationPropertyOfGeoreferencedTexture(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setOrientation(TransformationMatrix2x2 orientation) {
		if (orientation != null)
			orientation.setParent(this);

		this.orientation = orientation;
	}

	public void setPreferWorldFile(Boolean preferWorldFile) {
		this.preferWorldFile = preferWorldFile;
	}

	public void setReferencePoint(PointProperty referencePoint) {
		if (referencePoint != null)
			referencePoint.setParent(this);

		this.referencePoint = referencePoint;
	}

	public void setTarget(List<String> target) {
		this.target = target;
	}

	public void unsetGenericApplicationPropertyOfGeoreferencedTexture() {
		if (isSetGenericApplicationPropertyOfGeoreferencedTexture())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfGeoreferencedTexture(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfGeoreferencedTexture() ? this.ade.remove(ade) : false;
	}

	public void unsetOrientation() {
		if (isSetOrientation())
			orientation.unsetParent();

		orientation = null;
	}

	public void unsetPreferWorldFile() {
		preferWorldFile = null;
	}

	public void unsetReferencePoint() {
		if (isSetReferencePoint())
			referencePoint.unsetParent();

		referencePoint = null;
	}

	public void unsetTarget() {
		target = null;
	}

	public boolean unsetTarget(String target) {
		return isSetTarget() ? this.target.remove(target) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GEOREFERENCED_TEXTURE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeoreferencedTexture(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeoreferencedTexture copy = (target == null) ? new GeoreferencedTexture() : (GeoreferencedTexture)target;
		super.copyTo(copy, copyBuilder);

		if (isSetPreferWorldFile())
			copy.setPreferWorldFile(copyBuilder.copy(preferWorldFile));

		if (isSetReferencePoint()) {
			copy.setReferencePoint((PointProperty)copyBuilder.copy(referencePoint));
			if (copy.getReferencePoint() == referencePoint)
				referencePoint.setParent(this);
		}

		if (isSetOrientation()) {
			copy.setOrientation((TransformationMatrix2x2)copyBuilder.copy(orientation));
			if (copy.getOrientation() == orientation)
				orientation.setParent(this);
		}

		if (isSetTarget())
			copy.setTarget((List<String>)copyBuilder.copy(this.target));

		if (isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfGeoreferencedTexture(copyPart);

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
