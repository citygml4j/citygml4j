/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractBoundarySurface extends AbstractCityObject implements BridgeModuleComponent {
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<OpeningProperty> opening;
	private List<ADEComponent> ade;

	public AbstractBoundarySurface() {
		
	}
	
	public AbstractBoundarySurface(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfBoundarySurface(ADEComponent ade) {
		getGenericApplicationPropertyOfBoundarySurface().add(ade);
	}

	public void addOpening(OpeningProperty opening) {
		getOpening().add(opening);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBoundarySurface() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public List<OpeningProperty> getOpening() {
		if (opening == null)
			opening = new ChildList<>(this);

		return opening;
	}

	public boolean isSetGenericApplicationPropertyOfBoundarySurface() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetOpening() {
		return opening != null && !opening.isEmpty();
	}

	public void setGenericApplicationPropertyOfBoundarySurface(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		this.lod2MultiSurface = ModelObjects.setParent(lod2MultiSurface, this);
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
	}

	public void setOpening(List<OpeningProperty> opening) {
		this.opening = new ChildList<>(this, opening);
	}

	public void unsetGenericApplicationPropertyOfBoundarySurface() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfBoundarySurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBoundarySurface() && this.ade.remove(ade);
	}

	public void unsetLod2MultiSurface() {
		lod2MultiSurface = ModelObjects.setNull(lod2MultiSurface);
	}

	public void unsetLod3MultiSurface() {
		lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
	}

	public void unsetLod4MultiSurface() {
		lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
	}

	public void unsetOpening() {
		opening = ModelObjects.setNull(opening);
	}

	public boolean unsetOpening(OpeningProperty opening) {
		return isSetOpening() && this.opening.remove(opening);
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiSurfaceProperty = lod2MultiSurface;
				break;
			case 3:
				multiSurfaceProperty = lod3MultiSurface;
				break;
			case 4:
				multiSurfaceProperty = lod4MultiSurface;
				break;
			}

			if (multiSurfaceProperty != null) {
				if (multiSurfaceProperty.isSetMultiSurface()) {
					boundedBy.updateEnvelope(multiSurfaceProperty.getMultiSurface().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfBoundarySurface()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		lodRepresentation.addRepresentation(2, lod2MultiSurface);
		lodRepresentation.addRepresentation(3, lod3MultiSurface);
		lodRepresentation.addRepresentation(4, lod4MultiSurface);
		
		return lodRepresentation;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractBoundarySurface copy = (AbstractBoundarySurface)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetLod2MultiSurface()) {
			copy.setLod2MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod2MultiSurface));
			if (copy.getLod2MultiSurface() == lod2MultiSurface)
				lod2MultiSurface.setParent(this);
		}
		
		if (isSetLod3MultiSurface()) {
			copy.setLod3MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod3MultiSurface));
			if (copy.getLod3MultiSurface() == lod3MultiSurface)
				lod3MultiSurface.setParent(this);
		}

		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}
		
		if (isSetOpening()) {
			for (OpeningProperty part : opening) {
				OpeningProperty copyPart = (OpeningProperty)copyBuilder.copy(part);
				copy.addOpening(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBoundarySurface(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

}
