package org.citygml4j.impl.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;

public class FeaturePropertyImpl<T extends AbstractFeature> extends AssociationByRepOrRefImpl<T> implements FeatureProperty<T> {
	private ADEComponent genericADEComponent;
	
	public T getFeature() {
		return super.getObject();
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}

	public void setFeature(T feature) {
		super.setObject(feature);
	}

	public void unsetFeature() {
		super.unsetObject();
	}

	public ADEComponent getGenericADEComponent() {
		return genericADEComponent;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null;
	}
	
	public void setGenericADEComponent(ADEComponent genericADEComponent) {
		if (genericADEComponent != null)
			genericADEComponent.setParent(this);
		
		this.genericADEComponent = genericADEComponent;
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.unsetParent();
		
		genericADEComponent = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_PROPERTY;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureProperty<T> copy = (target == null) ? new FeaturePropertyImpl<T>() : (FeatureProperty<T>)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericADEComponent()) {
			copy.setGenericADEComponent((ADEComponent)copyBuilder.copy(genericADEComponent));
			if (copy.getGenericADEComponent() == genericADEComponent)
				genericADEComponent.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeaturePropertyImpl<T>(), copyBuilder);
	}

}
