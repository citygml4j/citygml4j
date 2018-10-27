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
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.util.bbox.BoundingBoxOptions;

public class RectifiedGridCoverage extends AbstractDiscreteCoverage {
	private RectifiedGridDomain rectifiedGridDomain;
	
	public RectifiedGridDomain getRectifiedGridDomain() {
		return rectifiedGridDomain;
	}

	public boolean isSetRectifiedGridDomain() {
		return rectifiedGridDomain != null;
	}

	public void setRectifiedGridDomain(RectifiedGridDomain rectifiedGridDomain) {
		if (rectifiedGridDomain != null)
			rectifiedGridDomain.setParent(this);
		
		this.rectifiedGridDomain = rectifiedGridDomain;
	}

	public void unsetRectifiedGridDomain() {
		if (isSetRectifiedGridDomain())
			rectifiedGridDomain.unsetParent();
		
		rectifiedGridDomain = null;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID_COVERAGE;
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetRectifiedGridDomain() && rectifiedGridDomain.isSetGeometry())
			boundedBy.updateEnvelope(rectifiedGridDomain.getGeometry().calcBoundingBox());
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridCoverage copy = (target == null) ? new RectifiedGridCoverage() : (RectifiedGridCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetRectifiedGridDomain()) {
			copy.setRectifiedGridDomain((RectifiedGridDomain)copyBuilder.copy(rectifiedGridDomain));
			if (copy.getRectifiedGridDomain() == rectifiedGridDomain)
				rectifiedGridDomain.setParent(this);
		}
		
		return copy;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridCoverage(), copyBuilder);
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
