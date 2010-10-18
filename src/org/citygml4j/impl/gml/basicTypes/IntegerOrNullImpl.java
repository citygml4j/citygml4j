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
package org.citygml4j.impl.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.Null;

public class IntegerOrNullImpl implements IntegerOrNull {
	private Integer _integer;
	private Null _null;
	private ModelObject parent;
	
	public IntegerOrNullImpl() {
		
	}
	
	public IntegerOrNullImpl(Integer _integer) {
		this._integer = _integer;
	}
	
	public IntegerOrNullImpl(Null _null) {
		setNull(_null);
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INTEGER_OR_NULL;
	}

	public Integer getInteger() {
		return _integer;
	}
	
	public Null getNull() {
		return _null;
	}

	public boolean isSetInteger() {
		return _integer != null;
	}
	
	public boolean isSetNull() {
		return _null != null;
	}

	public void setInteger(Integer _double) {
		this._integer = _double;
		
		unsetNull();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		unsetInteger();
	}

	public void unsetInteger() {
		_integer = null;
	}
	
	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();
		
		_null = null;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntegerOrNullImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntegerOrNull copy = (target == null) ? new IntegerOrNullImpl() : (IntegerOrNull)target;
		
		if (isSetInteger())
			copy.setInteger((Integer)copyBuilder.copy(_integer));
			
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
