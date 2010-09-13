package org.citygml4j.impl.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.valueObjects.GenericValueObject;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueObject;

public class ValueImpl implements Value {
	private ValueObject valueObject;
	private AbstractGeometry geometry;
	private GenericValueObject genericValueObject;
	private Null _null;
	private Object parent;
	
	public ValueImpl() {
		
	}
	
	public ValueImpl(ValueObject valueObject) {
		setValueObject(valueObject);
	}
	
	public ValueImpl(AbstractGeometry geometry) {
		setGeometry(geometry);
	}
	
	public ValueImpl(GenericValueObject genericValueObject) {
		setGenericValueObject(genericValueObject);
	}
	
	public ValueImpl(Null _null) {
		setNull(_null);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE;
	}

	public ValueObject getValueObject() {
		return valueObject;
	}

	public AbstractGeometry getGeometry() {
		return geometry;
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

	public boolean isSetGeometry() {
		return geometry != null;
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
		
		unsetGeometry();
		unsetNull();
		unsetGenericValueObject();
	}

	public void setGeometry(AbstractGeometry geometry) {
		if (geometry != null)
			geometry.setParent(this);
		
		this.geometry = geometry;
		
		unsetNull();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void setGenericValueObject(GenericValueObject genericValueObject) {
		if (genericValueObject != null)
			genericValueObject.setParent(this);
		
		this.genericValueObject = genericValueObject;
		
		unsetGeometry();
		unsetNull();
		unsetValueObject();
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);
		
		this._null = _null;
		
		unsetGeometry();
		unsetValueObject();
		unsetGenericValueObject();
	}

	public void unsetValueObject() {
		if (isSetValueObject())
			valueObject.unsetParent();
		
		valueObject = null;
	}

	public void unsetGeometry() {
		if (isSetGeometry())
			geometry.unsetParent();
		
		geometry = null;
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
		
		if (isSetGeometry()) {
			copy.setGeometry((AbstractGeometry)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
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
