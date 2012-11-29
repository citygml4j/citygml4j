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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public abstract class AbstractCurveSegment implements GML, Associable, Child, Copyable {
	private Integer numDerivativesAtStart;
	private Integer numDerivativesAtEnd;
	private Integer numDerivativeInterior;	
	private ModelObject parent;

	public Integer getNumDerivativeInterior() {
		if (!isSetNumDerivativeInterior())
			return 0;
		else
			return numDerivativeInterior;
	}

	public Integer getNumDerivativesAtEnd() {
		if (!isSetNumDerivativesAtEnd())
			return 0;
		else
			return numDerivativesAtEnd;
	}

	public Integer getNumDerivativesAtStart() {
		if (!isSetNumDerivativesAtStart())
			return 0;
		else
			return numDerivativesAtStart;
	}

	public boolean isSetNumDerivativeInterior() {
		return numDerivativeInterior != null;
	}

	public boolean isSetNumDerivativesAtEnd() {
		return numDerivativesAtEnd != null;
	}

	public boolean isSetNumDerivativesAtStart() {
		return numDerivativesAtStart != null;
	}

	public void setNumDerivativeInterior(Integer numDerivativeInterior) {
		this.numDerivativeInterior = numDerivativeInterior;
	}

	public void setNumDerivativesAtEnd(Integer numDerivativesAtEnd) {
		this.numDerivativesAtEnd = numDerivativesAtEnd;
	}

	public void setNumDerivativesAtStart(Integer numDerivativesAtStart) {
		this.numDerivativesAtStart = numDerivativesAtStart;
	}

	public void unsetNumDerivativeInterior() {
		numDerivativeInterior = null;
	}

	public void unsetNumDerivativesAtEnd() {
		numDerivativesAtEnd = null;
	}

	public void unsetNumDerivativesAtStart() {
		numDerivativesAtStart = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCurveSegment copy = (AbstractCurveSegment)target;

		if (isSetNumDerivativeInterior())
			copy.setNumDerivativeInterior((Integer)copyBuilder.copy(numDerivativeInterior));

		if (isSetNumDerivativesAtEnd())
			copy.setNumDerivativesAtEnd((Integer)copyBuilder.copy(numDerivativesAtEnd));

		if (isSetNumDerivativesAtStart())
			copy.setNumDerivativesAtStart((Integer)copyBuilder.copy(numDerivativesAtStart));

		copy.unsetParent();

		return copy;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public abstract BoundingBox calcBoundingBox();

}
