/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.BuildingModule;

public class BuildingPart extends AbstractBuilding {
	private List<ADEComponent> ade;

	public BuildingPart() {

	}

	public BuildingPart(BuildingModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfBuildingPart(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBuildingPart() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfBuildingPart() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfBuildingPart(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfBuildingPart() {
		if (isSetGenericApplicationPropertyOfBuildingPart())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBuildingPart(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBuildingPart() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING_PART;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingPart(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AbstractBuilding copy = (target == null) ? new BuildingPart() : (AbstractBuilding)target;
		super.copyTo(copy, copyBuilder);

		if (copy.getCityGMLClass() == CityGMLClass.BUILDING_PART) {
			if (isSetGenericApplicationPropertyOfBuildingPart()) {
				for (ADEComponent part : ade) {
					ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
					((BuildingPart)copy).addGenericApplicationPropertyOfBuildingPart(copyPart);

					if (part != null && copyPart == part)
						part.setParent(this);
				}
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
