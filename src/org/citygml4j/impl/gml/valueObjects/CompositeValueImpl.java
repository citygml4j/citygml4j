package org.citygml4j.impl.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AbstractGMLImpl;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;
import org.citygml4j.model.gml.valueObjects.ValueProperty;

public class CompositeValueImpl extends AbstractGMLImpl implements CompositeValue {
	private List<ValueProperty> valueComponent;
	private ValueArrayProperty valueComponents;

	public List<ValueProperty> getValueComponent() {
		if (valueComponent == null)
			valueComponent = new ChildList<ValueProperty>(this);
		
		return valueComponent;
	}

	public ValueArrayProperty getValueComponents() {
		return valueComponents;
	}

	public boolean isSetValueComponent() {
		return valueComponent != null && !valueComponent.isEmpty();
	}

	public boolean isSetValueComponents() {
		return valueComponents != null;
	}

	public void addValueComponent(ValueProperty valueComponent) {
		if (this.valueComponent == null)
			this.valueComponent = new ChildList<ValueProperty>(this);
		
		this.valueComponent.add(valueComponent);
	}

	public void setValueComponent(List<ValueProperty> valueComponent) {
		this.valueComponent = new ChildList<ValueProperty>(this, valueComponent);
	}

	public void setValueComponents(ValueArrayProperty valueComponents) {
		if (valueComponents != null)
			valueComponents.setParent(this);
		
		this.valueComponents = valueComponents;
	}

	public boolean unsetValueComponent(ValueProperty valueComponent) {
		return isSetValueComponent() ? this.valueComponent.remove(valueComponent) : false;
	}

	public void unsetValueComponent() {
		if (isSetValueComponent())
			valueComponent.clear();
		
		valueComponent = null;
	}

	public void unsetValueComponents() {
		if (isSetValueComponents())
			valueComponents.unsetParent();
		
		valueComponents = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_VALUE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeValue copy = (target == null) ? new CompositeValueImpl() : (CompositeValue)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValueComponent()) {
			for (ValueProperty part : valueComponent) {
				ValueProperty copyPart = (ValueProperty)copyBuilder.copy(part);
				copy.addValueComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetValueComponents()) {
			copy.setValueComponents((ValueArrayProperty)copyBuilder.copy(valueComponents));
			if (copy.getValueComponents() == valueComponents)
				valueComponents.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeValueImpl(), copyBuilder);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
