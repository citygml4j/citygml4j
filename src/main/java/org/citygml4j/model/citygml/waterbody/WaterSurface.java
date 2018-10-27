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
package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class WaterSurface extends AbstractWaterBoundarySurface {
	private Code waterLevel;
	private List<ADEComponent> ade;

	public WaterSurface() {

	}

	public WaterSurface(WaterBodyModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public Code getWaterLevel() {
		return waterLevel;
	}

	public boolean isSetGenericApplicationPropertyOfWaterSurface() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetWaterLevel() {
		return waterLevel != null;
	}

	public void setGenericApplicationPropertyOfWaterSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setWaterLevel(Code waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void unsetGenericApplicationPropertyOfWaterSurface() {
		if (isSetGenericApplicationPropertyOfWaterSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterSurface() ? this.ade.remove(ade) : false;
	}

	public void unsetWaterLevel() {
		waterLevel = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATER_SURFACE;
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfWaterSurface()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WaterSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WaterSurface copy = (target == null) ? new WaterSurface() : (WaterSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetWaterLevel())
			copy.setWaterLevel((Code)copyBuilder.copy(waterLevel));
		
		if (isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterSurface(copyPart);

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
