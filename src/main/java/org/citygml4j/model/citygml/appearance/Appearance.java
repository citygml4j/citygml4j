/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.List;

public class Appearance extends AbstractFeature implements AppearanceModuleComponent {
	private String theme;
	private List<SurfaceDataProperty> surfaceDataMember;
	private List<ADEComponent> ade;

	public Appearance() {
		
	}
	
	public Appearance(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfAppearance(ADEComponent ade) {
		getGenericApplicationPropertyOfAppearance().add(ade);
	}

	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		getSurfaceDataMember().add(surfaceDataMember);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAppearance() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public List<SurfaceDataProperty> getSurfaceDataMember() {
		if (surfaceDataMember == null)
			surfaceDataMember = new ChildList<>(this);

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
		this.ade = new ChildList<>(this, ade);
	}

	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember) {
		this.surfaceDataMember = new ChildList<>(this, surfaceDataMember);
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void unsetGenericApplicationPropertyOfAppearance() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAppearance() && this.ade.remove(ade);
	}

	public void unsetSurfaceDataMember() {
		surfaceDataMember = ModelObjects.setNull(surfaceDataMember);
	}

	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		return isSetSurfaceDataMember() && this.surfaceDataMember.remove(surfaceDataMember);
	}

	public void unsetTheme() {
		theme = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Appearance(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Appearance copy = (target == null) ? new Appearance() : (Appearance)target;
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
