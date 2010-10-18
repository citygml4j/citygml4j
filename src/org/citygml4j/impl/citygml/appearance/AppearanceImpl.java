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
package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.AbstractFeatureImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearanceImpl extends AbstractFeatureImpl implements Appearance {
	private String theme;
	private List<SurfaceDataProperty> surfaceDataMember;
	private List<ADEComponent> ade;
	private AppearanceModule module;
	
	public AppearanceImpl() {
		
	}
	
	public AppearanceImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfAppearance(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		if (this.surfaceDataMember == null)
			this.surfaceDataMember = new ChildList<SurfaceDataProperty>(this);

		this.surfaceDataMember.add(surfaceDataMember);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAppearance() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<SurfaceDataProperty> getSurfaceDataMember() {
		if (surfaceDataMember == null)
			surfaceDataMember = new ChildList<SurfaceDataProperty>(this);

		return surfaceDataMember;
	}

	public String getTheme() {
		return theme;
	}

	public boolean isSetGenericApplicationPropertyOfAppearance() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetSurfaceDataMember() {
		return surfaceDataMember != null && !surfaceDataMember.isEmpty();
	}

	public boolean isSetTheme() {
		return theme != null;
	}

	public void setGenericApplicationPropertyOfAppearance(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember) {
		this.surfaceDataMember = new ChildList<SurfaceDataProperty>(this, surfaceDataMember);
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void unsetGenericApplicationPropertyOfAppearance() {
		if (isSetGenericApplicationPropertyOfAppearance())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAppearance() ? this.ade.remove(ade) : false;
	}

	public void unsetSurfaceDataMember() {
		if (isSetSurfaceDataMember())
			surfaceDataMember.clear();

		surfaceDataMember = null;
	}

	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		return isSetSurfaceDataMember() ? this.surfaceDataMember.remove(surfaceDataMember) : false;
	}

	public void unsetTheme() {
		theme = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AppearanceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Appearance copy = (target == null) ? new AppearanceImpl() : (Appearance)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTheme())
			copy.setTheme(copyBuilder.copy(theme));
		
		if (isSetSurfaceDataMember()) {
			for (SurfaceDataProperty part : this.surfaceDataMember) {
				SurfaceDataProperty copyPart = (SurfaceDataProperty)copyBuilder.copy(part);
				copy.addSurfaceDataMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAppearance(copyPart);

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
