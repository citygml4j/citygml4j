/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: AbstractDiscreteCoverage.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;

public abstract class AbstractDiscreteCoverage extends AbstractCoverage {
	private CoverageFunction coverageFunction;	

	public CoverageFunction getCoverageFunction() {
		return coverageFunction;
	}

	public boolean isSetCoverageFunction() {
		return coverageFunction != null;
	}

	public void setCoverageFunction(CoverageFunction coverageFunction) {
		if (coverageFunction != null)
			coverageFunction.setParent(this);
		
		this.coverageFunction = coverageFunction;
	}

	public void unsetCoverageFunction() {
		if (isSetCoverageFunction())
			coverageFunction.unsetParent();
		
		coverageFunction = null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractDiscreteCoverage copy = (AbstractDiscreteCoverage)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCoverageFunction()) {
			copy.setCoverageFunction((CoverageFunction)copyBuilder.copy(coverageFunction));
			if (copy.getCoverageFunction() == coverageFunction)
				coverageFunction.setParent(this);
		}
		
		return copy;
	}

}
