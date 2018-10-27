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
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class BreaklineRelief extends AbstractReliefComponent {
	private MultiCurveProperty ridgeOrValleyLines;
	private MultiCurveProperty breaklines;
	private List<ADEComponent> ade;

	public BreaklineRelief() {

	}

	public BreaklineRelief(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfBreaklineRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public MultiCurveProperty getBreaklines() {
		return breaklines;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBreaklineRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiCurveProperty getRidgeOrValleyLines() {
		return ridgeOrValleyLines;
	}

	public boolean isSetBreaklines() {
		return breaklines != null;
	}

	public boolean isSetGenericApplicationPropertyOfBreaklineRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetRidgeOrValleyLines() {
		return ridgeOrValleyLines != null;
	}

	public void setBreaklines(MultiCurveProperty breaklines) {
		if (breaklines != null)
			breaklines.setParent(this);

		this.breaklines = breaklines;
	}

	public void setGenericApplicationPropertyOfBreaklineRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setRidgeOrValleyLines(MultiCurveProperty ridgeOrValleyLines) {
		if (ridgeOrValleyLines != null)
			ridgeOrValleyLines.setParent(this);

		this.ridgeOrValleyLines = ridgeOrValleyLines;
	}

	public void unsetBreaklines() {
		if (isSetBreaklines())
			breaklines.unsetParent();

		breaklines = null;
	}

	public void unsetGenericApplicationPropertyOfBreaklineRelief() {
		if (isSetGenericApplicationPropertyOfBreaklineRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBreaklineRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBreaklineRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetRidgeOrValleyLines() {
		if (isSetRidgeOrValleyLines())
			ridgeOrValleyLines.unsetParent();

		ridgeOrValleyLines = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BREAKLINE_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;

		if (isSetBreaklines()) {
			if (breaklines.isSetMultiCurve()) {
				boundedBy.updateEnvelope(breaklines.getMultiCurve().calcBoundingBox());
			} else {
				// xlink
			}
		}

		if (isSetRidgeOrValleyLines()) {
			if (ridgeOrValleyLines.isSetMultiCurve()) {
				boundedBy.updateEnvelope(ridgeOrValleyLines.getMultiCurve().calcBoundingBox());
			} else {
				// xlink
			}
		}

		if (isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfBreaklineRelief()) {
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

		if (ridgeOrValleyLines != null)
			lodRepresentation.addRepresentation(getLod(), ridgeOrValleyLines);

		if (breaklines != null)
			lodRepresentation.addRepresentation(getLod(), breaklines);

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BreaklineRelief(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BreaklineRelief copy = (target == null) ? new BreaklineRelief() : (BreaklineRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetBreaklines()) {
			copy.setBreaklines((MultiCurveProperty)copyBuilder.copy(breaklines));
			if (copy.getBreaklines() == breaklines)
				breaklines.setParent(this);
		}

		if (isSetRidgeOrValleyLines()) {
			copy.setRidgeOrValleyLines((MultiCurveProperty)copyBuilder.copy(ridgeOrValleyLines));
			if (copy.getRidgeOrValleyLines() == ridgeOrValleyLines)
				ridgeOrValleyLines.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBreaklineRelief(copyPart);

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
