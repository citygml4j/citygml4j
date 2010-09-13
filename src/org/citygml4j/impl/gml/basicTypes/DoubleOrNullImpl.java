package org.citygml4j.impl.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.Null;

public class DoubleOrNullImpl implements DoubleOrNull {
	private Double _double;
	private Null _null;
	private Object parent;
	
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

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
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
