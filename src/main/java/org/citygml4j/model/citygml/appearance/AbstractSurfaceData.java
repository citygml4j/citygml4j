/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.List;

public abstract class AbstractSurfaceData extends AbstractFeature implements AppearanceModuleComponent {
	private Boolean isFront;
	private List<ADEComponent> ade;

	public AbstractSurfaceData() {
		
	}
	
	public AbstractSurfaceData(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		getGenericApplicationPropertyOfSurfaceData().add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public Boolean getIsFront() {
		return !isSetIsFront() ? true : isFront;
	}

	public boolean isSetGenericApplicationPropertyOfSurfaceData() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetIsFront() {
		return isFront != null;
	}

	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setIsFront(Boolean isFront) {
		this.isFront = isFront;
	}

	public void unsetGenericApplicationPropertyOfSurfaceData() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSurfaceData() && this.ade.remove(ade);
	}

	public void unsetIsFront() {
		isFront = null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSurfaceData copy = (AbstractSurfaceData)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetIsFront())
			copy.setIsFront(copyBuilder.copy(isFront));

		if (isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSurfaceData(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

}
