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
import org.citygml4j.model.gml.feature.AbstractFeature;

public abstract class AbstractCoverage extends AbstractFeature {
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
