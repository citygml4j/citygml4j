/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
	private TinProperty tin;
	private List<ADEComponent> ade;

	public TINRelief() {

	}

	public TINRelief(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfTinRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTinRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public TinProperty getTin() {
		return tin;
	}

	public boolean isSetGenericApplicationPropertyOfTinRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetTin() {
		return tin != null;
	}

	public void setGenericApplicationPropertyOfTinRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setTin(TinProperty tin) {
		if (tin != null)
			tin.setParent(this);

		this.tin = tin;
	}

	public void unsetGenericApplicationPropertyOfTinRelief() {
		if (isSetGenericApplicationPropertyOfTinRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTinRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTinRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetTin() {
		if (isSetTin())
			tin.unsetParent();

		tin = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TIN_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetTin()) {
			if (tin.isSetObject()) {
				boundedBy.updateEnvelope(tin.getObject().calcBoundingBox());
			} else {
				// xlink
			}
		}
		
		if (isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfTinRelief()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}

		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		if (tin != null)
			lodRepresentation.addRepresentation(getLod(), tin);
		
		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TINRelief(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TINRelief copy = (target == null) ? new TINRelief() : (TINRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetTin()) {
			copy.setTin((TinProperty)copyBuilder.copy(tin));
			if (copy.getTin() == tin)
				tin.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTinRelief(copyPart);

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
