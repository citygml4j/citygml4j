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
