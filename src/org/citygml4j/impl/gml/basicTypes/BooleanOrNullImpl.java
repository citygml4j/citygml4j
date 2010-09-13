package org.citygml4j.impl.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.BooleanOrNull;
import org.citygml4j.model.gml.basicTypes.Null;

public class BooleanOrNullImpl implements BooleanOrNull {
	private Boolean _boolean;
	private Null _null;
	private Object parent;
	
	public BooleanOrNullImpl() {
		
	}
	
	public BooleanOrNullImpl(Boolean _boolean) {
		this._boolean = _boolean;
	}
	
	public BooleanOrNullImpl(Null _null) {
		setNull(_null);
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.BOOLEAN_OR_NULL;
	}

	public Boolean getBoolean() {
		return _boolean;
	}
	
	public Null getNull() {
		return _null;
	}

	public boolean isSetBoolean() {
		return _boolean != null;
	}
	
	public boolean isSetNull() {
		return _null != null;
	}

	public void setBoolean(Boolean _boolean) {
		this._boolean = _boolean;
		
		unsetNull();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		unsetBoolean();
	}

	public void unsetBoolean() {
		_boolean = null;
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
		return copyTo(new BooleanOrNullImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BooleanOrNull copy = (target == null) ? new BooleanOrNullImpl() : (BooleanOrNull)target;
		
		if (isSetBoolean())
			copy.setBoolean((Boolean)copyBuilder.copy(_boolean));
			
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
