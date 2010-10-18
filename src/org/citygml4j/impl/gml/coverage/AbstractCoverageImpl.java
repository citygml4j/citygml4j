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
package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.AbstractFeatureImpl;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.RangeSet;

public abstract class AbstractCoverageImpl extends AbstractFeatureImpl implements AbstractCoverage {
	private RangeSet rangeSet;
	private Integer dimension;
	
	public RangeSet getRangeSet() {
		return rangeSet;
	}
	
	public Integer getDimension() {
		return dimension;
	}

	public boolean isSetRangeSet() {
		return rangeSet != null;
	}
	
	public boolean isSetDimension() {
		return dimension != null;
	}
	
	public void setRangeSet(RangeSet rangeSet) {
		if (rangeSet != null)
			rangeSet.setParent(this);
		
		this.rangeSet = rangeSet;
	}

	public void setDimension(Integer dimension) {
		if (dimension > 0)
			this.dimension = dimension;
	}
	
	public void unsetRangeSet() {
		if (isSetRangeSet())
			rangeSet.unsetParent();
		
		rangeSet = null;
	}

	public void unsetDimension() {
		dimension = null;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCoverage copy = (AbstractCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetRangeSet()) {
			copy.setRangeSet((RangeSet)copyBuilder.copy(rangeSet));
			if (copy.getRangeSet() == rangeSet)
				rangeSet.setParent(this);
		}
		
		if (isSetDimension())
			copy.setDimension((Integer)copyBuilder.copy(dimension));
		
		return copy;
	}
	
}
