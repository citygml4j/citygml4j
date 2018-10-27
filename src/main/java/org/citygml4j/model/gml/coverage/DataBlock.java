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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.basicTypes.DoubleOrNullList;

public class DataBlock implements GML, Child, Copyable {
	private RangeParameters rangeParameters;
	private Coordinates tupleList;
	private DoubleOrNullList doubleOrNullTupleList;
	private ModelObject parent;

	public GMLClass getGMLClass() {
		return GMLClass.DATA_BLOCK;
	}

	public RangeParameters getRangeParameters() {
		return rangeParameters;
	}

	public Coordinates getTupleList() {
		return tupleList;
	}

	public DoubleOrNullList getDoubleOrNullTupleList() {
		return doubleOrNullTupleList;
	}

	public boolean isSetRangeParameters() {
		return rangeParameters != null;
	}

	public boolean isSetTupleList() {
		return tupleList != null;
	}

	public boolean isSetDoubleOrNullTupleList() {
		return doubleOrNullTupleList != null;
	}

	public void setRangeParameters(RangeParameters rangeParameters) {
		if (rangeParameters != null)
			rangeParameters.setParent(this);
		
		this.rangeParameters = rangeParameters;
	}

	public void setTupleList(Coordinates tupleList) {
		if (tupleList != null)
			tupleList.setParent(this);
		
		this.tupleList = tupleList;
		
		unsetDoubleOrNullTupleList();
	}

	public void setDoubleOrNullTupleList(DoubleOrNullList doubleOrNullTupleList) {
		if (doubleOrNullTupleList != null)
			doubleOrNullTupleList.setParent(this);
		
		this.doubleOrNullTupleList = doubleOrNullTupleList;
		
		unsetTupleList();
	}

	public void unsetRangeParameters() {
		if (isSetRangeParameters())
			rangeParameters.unsetParent();
		
		rangeParameters = null;
	}

	public void unsetTupleList() {
		if (isSetTupleList())
			tupleList.unsetParent();
		
		tupleList = null;
	}

	public void unsetDoubleOrNullTupleList() {
		if (isSetDoubleOrNullTupleList())
			doubleOrNullTupleList.unsetParent();
		
		doubleOrNullTupleList = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DataBlock copy = (target == null) ? new DataBlock() : (DataBlock)target;
		
		if (isSetRangeParameters()) {
			copy.setRangeParameters((RangeParameters)copyBuilder.copy(rangeParameters));
			if (copy.getRangeParameters() == rangeParameters)
				rangeParameters.setParent(this);
		}
		
		if (isSetTupleList()) {
			copy.setTupleList((Coordinates)copyBuilder.copy(tupleList));
			if (copy.getTupleList() == tupleList)
				tupleList.setParent(this);
		}
		
		if (isSetDoubleOrNullTupleList()) {
			copy.setDoubleOrNullTupleList((DoubleOrNullList)copyBuilder.copy(doubleOrNullTupleList));
			if (copy.getDoubleOrNullTupleList() == doubleOrNullTupleList)
				doubleOrNullTupleList.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DataBlock(), copyBuilder);
	}

}
