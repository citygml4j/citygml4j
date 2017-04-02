package org.citygml4j.model.citygml.ade.binding;

import java.lang.reflect.ParameterizedType;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;

public abstract class ADEGenericApplicationProperty<T> implements ADEModelObject {
	private T value;
	private ModelObject parent;
	
	public ADEGenericApplicationProperty() {
	}
	
	public ADEGenericApplicationProperty(T value) {
		setValue(value);
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		if (value instanceof Child)
			((Child)value).setParent(this);
			
		this.value = value;
	}

	@Override
	public ModelObject getParent() {
		return parent;
	}

	@Override
	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	@Override
	public boolean isSetParent() {
		return parent != null;
	}

	@Override
	public void unsetParent() {
		parent = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE_COMPONENT;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML_ADE;
	}
	
	@Override
	public ADEClass getADEClass() {
		return ADEClass.MODEL_OBJECT;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");
		
		if (target instanceof ADEGenericApplicationProperty<?>) {
			Class<?> type = inferValueType();
			
			if (((ADEGenericApplicationProperty<?>)target).inferValueType() == type) {				
				ADEGenericApplicationProperty<T> copy = (ADEGenericApplicationProperty<T>)target;
				Object copyValue = null;
				
				copyValue = copyBuilder.copy(value);
				if (copyValue != null)
					copy.setValue((T)copyValue);
				
				copy.unsetParent();				
				return copy;
			}
		}
		
		return target;
	}
	
	private Class<?> inferValueType() {		
		Class<?> cls = this.getClass();
		while (!(cls.getSuperclass() == null || cls.getSuperclass().equals(ADEGenericApplicationProperty.class)))
			cls = cls.getSuperclass();
		
		return cls.getSuperclass() != null ? (Class<?>)((ParameterizedType)cls.getGenericSuperclass()).getActualTypeArguments()[0] : null;
	}
	
}
