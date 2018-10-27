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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractReliefComponent extends AbstractCityObject implements ReliefModuleComponent {
	private int lod;
	private PolygonProperty extent;
	private List<ADEComponent> ade;
	private ReliefModule module;

	public AbstractReliefComponent() {
		
	}
	
	public AbstractReliefComponent(ReliefModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);
		
		this.ade.add(ade);
	}

	public PolygonProperty getExtent() {
		return extent;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefComponent() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public int getLod() {
		return lod;
	}

	public boolean isSetExtent() {
		return extent != null;
	}

	public boolean isSetGenericApplicationPropertyOfReliefComponent() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod() {
		return true;
	}

	public void setExtent(PolygonProperty extent) {
		if (extent != null)
			extent.setParent(this);

		this.extent = extent;
	}

	public void setGenericApplicationPropertyOfReliefComponent(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod(int lod) {
		if (lod >= 0 && lod <= 4)
			this.lod = lod;
	}

	public void unsetExtent() {
		if (isSetExtent())
			extent.unsetParent();

		extent = null;
	}

	public void unsetGenericApplicationPropertyOfReliefComponent() {
		if (isSetGenericApplicationPropertyOfReliefComponent())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfReliefComponent() ? this.ade.remove(ade) : false;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetExtent()) {
			if (extent.isSetPolygon()) {
				boundedBy.updateEnvelope(extent.getPolygon().calcBoundingBox());	
			} else {
				// xlink
			}
		}
		
		if (isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfReliefComponent()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractReliefComponent copy = (AbstractReliefComponent)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetLod())
			copy.setLod(copyBuilder.copy(lod));

		if (isSetExtent()) {
			copy.setExtent((PolygonProperty)copyBuilder.copy(extent));
			if (copy.getExtent() == extent)
				extent.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfReliefComponent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
}
