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
package org.citygml4j.model.citygml.waterbody;

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
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractWaterBoundarySurface extends AbstractCityObject implements WaterBodyModuleComponent {
	private SurfaceProperty lod2Surface;
	private SurfaceProperty lod3Surface;
	private SurfaceProperty lod4Surface;
	private List<ADEComponent> ade;

	public AbstractWaterBoundarySurface() {

	}

	public AbstractWaterBoundarySurface(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent ade) {
		getGenericApplicationPropertyOfWaterBoundarySurface().add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterBoundarySurface() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public SurfaceProperty getLod2Surface() {
		return lod2Surface;
	}

	public SurfaceProperty getLod3Surface() {
		return lod3Surface;
	}

	public SurfaceProperty getLod4Surface() {
		return lod4Surface;
	}

	public boolean isSetGenericApplicationPropertyOfWaterBoundarySurface() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod2Surface() {
		return lod2Surface != null;
	}

	public boolean isSetLod3Surface() {
		return lod3Surface != null;
	}

	public boolean isSetLod4Surface() {
		return lod4Surface != null;
	}

	public void setGenericApplicationPropertyOfWaterBoundarySurface(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setLod2Surface(SurfaceProperty lod2Surface) {
		this.lod2Surface = ModelObjects.setParent(lod2Surface, this);
	}

	public void setLod3Surface(SurfaceProperty lod3Surface) {
		this.lod3Surface = ModelObjects.setParent(lod3Surface, this);
	}

	public void setLod4Surface(SurfaceProperty lod4Surface) {
		this.lod4Surface = ModelObjects.setParent(lod4Surface, this);
	}

	public void unsetGenericApplicationPropertyOfWaterBoundarySurface() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterBoundarySurface() && this.ade.remove(ade);
	}

	public void unsetLod2Surface() {
		lod2Surface = ModelObjects.setNull(lod2Surface);
	}

	public void unsetLod3Surface() {
		lod3Surface = ModelObjects.setNull(lod3Surface);
	}

	public void unsetLod4Surface() {
		lod4Surface = ModelObjects.setNull(lod4Surface);
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		SurfaceProperty surfaceProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				surfaceProperty = lod2Surface;
				break;
			case 3:
				surfaceProperty = lod3Surface;
				break;
			case 4:
				surfaceProperty = lod4Surface;
				break;
			}

			if (surfaceProperty != null) {
				if (surfaceProperty.isSetSurface()) {
					boundedBy.updateEnvelope(surfaceProperty.getSurface().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfWaterBoundarySurface()) {
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

		lodRepresentation.addRepresentation(2, lod2Surface);
		lodRepresentation.addRepresentation(3, lod3Surface);
		lodRepresentation.addRepresentation(4, lod4Surface);
		
		return lodRepresentation;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractWaterBoundarySurface copy = (AbstractWaterBoundarySurface)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetLod2Surface()) {
			copy.setLod2Surface((SurfaceProperty)copyBuilder.copy(lod2Surface));
			if (copy.getLod2Surface() == lod2Surface)
				lod2Surface.setParent(this);
		}
		
		if (isSetLod3Surface()) {
			copy.setLod3Surface((SurfaceProperty)copyBuilder.copy(lod3Surface));
			if (copy.getLod3Surface() == lod3Surface)
				lod3Surface.setParent(this);
		}
		
		if (isSetLod4Surface()) {
			copy.setLod4Surface((SurfaceProperty)copyBuilder.copy(lod4Surface));
			if (copy.getLod4Surface() == lod4Surface)
				lod4Surface.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterBoundarySurface(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
}
