package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GenericValueObject;
import org.citygml4j.model.gml.Null;
import org.citygml4j.model.gml.Value;
import org.citygml4j.model.gml.ValueObject;

public class ValueImpl implements Value {
	private ValueObject valueObject;
	private AbstractGML gmlObject;
	private GenericValueObject genericValueObject;
	private Null _null;
	private Object parent;
	
	public ValueImpl() {
		
	}
	
	public ValueImpl(ValueObject valueObject) {
		setValueObject(valueObject);
	}
	
	public ValueImpl(AbstractGML gmlObject) {
		setGMLObject(gmlObject);
	}
	
	public ValueImpl(GenericValueObject genericValueObject) {
		setGenericValueObject(genericValueObject);
	}
	
	public ValueImpl(Null _null) {
		setNull(_null);
	}

	public GMLClass getGMLClass() {
		return GMLClass.VALUE;
	}

	public ValueObject getValueObject() {
		return valueObject;
	}

	public AbstractGML getGMLObject() {
		return gmlObject;
	}

	public GenericValueObject getGenericValueObject() {
		return genericValueObject;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetValueObject() {
		return valueObject != null;
	}

	public boolean isSetGMLObject() {
		return gmlObject != null;
	}

	public boolean isSetGenericValueObject() {
		return genericValueObject != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setValueObject(ValueObject valueObject) {
		if (valueObject != null)
			valueObject.setParent(this);
		
		this.valueObject = valueObject;
		
		unsetGMLObject();
		unsetNull();
		unsetGenericValueObject();
	}

	public void setGMLObject(AbstractGML gmlObject) {
		if (gmlObject != null)
			gmlObject.setParent(this);
		
		this.gmlObject = gmlObject;
		
		unsetNull();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void setGenericValueObject(GenericValueObject genericValueObject) {
		if (genericValueObject != null)
			genericValueObject.setParent(this);
		
		this.genericValueObject = genericValueObject;
		
		unsetGMLObject();
		unsetNull();
		unsetValueObject();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		
		unsetGMLObject();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void unsetValueObject() {
		if (isSetValueObject())
			valueObject.unsetParent();
		
		valueObject = null;
	}

	public void unsetGMLObject() {
		if (isSetGMLObject())
			gmlObject.unsetParent();
		
		gmlObject = null;
	}

	public void unsetGenericValueObject() {
		if (isSetGenericValueObject())
			genericValueObject.unsetParent();
		
		genericValueObject = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();
		
		_null = null;
	}
	
	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Value copy = (target == null) ? new ValueImpl() : (Value)target;
		
		if (isSetValueObject()) {
			copy.setValueObject((ValueObject)copyBuilder.copy(valueObject));
			if (copy.getValueObject() == valueObject)
				valueObject.setParent(this);
		}
		
		if (isSetGMLObject()) {
			copy.setGMLObject((AbstractGML)copyBuilder.copy(gmlObject));
			if (copy.getGMLObject() == gmlObject)
				gmlObject.setParent(this);
		}
		
		if (isSetGenericValueObject()) {
			copy.setGenericValueObject((GenericValueObject)copyBuilder.copy(genericValueObject));
			if (copy.getGenericValueObject() == genericValueObject)
				genericValueObject.setParent(this);
		}
		
		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueImpl(), copyBuilder);
	}

}
