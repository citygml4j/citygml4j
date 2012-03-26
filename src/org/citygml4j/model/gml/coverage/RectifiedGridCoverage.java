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
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.BoundingShape;

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
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();
		
		if (isSetRectifiedGridDomain() && rectifiedGridDomain.isSetGeometry())
			calcBoundedBy(boundedBy, rectifiedGridDomain.getGeometry());
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
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
