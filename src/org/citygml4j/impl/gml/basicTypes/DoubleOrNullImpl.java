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
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.Null;

public class DoubleOrNullImpl implements DoubleOrNull {
	private Double _double;
	private Null _null;
	private ModelObject parent;
	
	public DoubleOrNullImpl() {
		
	}
	
	public DoubleOrNullImpl(Double _double) {
		this._double = _double;
	}
	
	public DoubleOrNullImpl(Null _null) {
		setNull(_null);
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.DOUBLE_OR_NULL;
	}

	public Double getDouble() {
		return _double;
	}
	
	public Null getNull() {
		return _null;
	}

	public boolean isSetDouble() {
		return _double != null;
	}
	
	public boolean isSetNull() {
		return _null != null;
	}

	public void setDouble(Double _double) {
		this._double = _double;
		
		unsetNull();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		unsetDouble();
	}

	public void unsetDouble() {
		_double = null;
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
		return copyTo(new DoubleOrNullImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleOrNull copy = (target == null) ? new DoubleOrNullImpl() : (DoubleOrNull)target;
		
		if (isSetDouble())
			copy.setDouble((Double)copyBuilder.copy(_double));
			
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
