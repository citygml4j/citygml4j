package org.citygml4j.impl.gml.feature;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;

public class FeatureArrayPropertyImpl extends ArrayAssociationImpl<AbstractFeature> implements FeatureArrayProperty {
	private List<ADEComponent> genericADEComponent;
	
	public void addFeature(AbstractFeature feature) {
		super.addObject(feature);
	}
	
	public void addGenericADEComponent(ADEComponent genericADEComponent) {
		if (this.genericADEComponent == null)
			this.genericADEComponent = new ChildList<ADEComponent>(this);
		
		this.genericADEComponent.add(genericADEComponent);
	}

	public List<? extends AbstractFeature> getFeature() {
		return super.getObject();
	}
	
	public List<ADEComponent> getGenericADEComponent() {
		if (genericADEComponent == null)
			genericADEComponent = new ChildList<ADEComponent>(this);
		
		return genericADEComponent;
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}
	
	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null && !genericADEComponent.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public void setFeature(List<? extends AbstractFeature> feature) {
		super.setObject((List<AbstractFeature>)feature);
	}
	
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent) {
		this.genericADEComponent = new ChildList<ADEComponent>(this, genericADEComponent);
	}

	public void unsetFeature() {
		super.unsetObject();
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.clear();
		
		genericADEComponent = null;
	}

	public boolean unsetFeature(AbstractFeature feature) {
		return super.unsetObject(feature);
	}
	
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent) {
		return isSetGenericADEComponent() ? this.genericADEComponent.remove(genericADEComponent) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureArrayProperty copy = (target == null) ? new FeatureArrayPropertyImpl() : (FeatureArrayProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericADEComponent()) {
			for (ADEComponent part : genericADEComponent) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericADEComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
