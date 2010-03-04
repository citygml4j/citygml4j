package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class FeatureArrayPropertyImpl implements FeatureArrayProperty {
	private List<AbstractFeature> feature;
	private List<ADEComponent> genericADEComponent;
	private Object parent;
	
	public void addFeature(AbstractFeature feature) {
		if (this.feature == null)
			this.feature = new ChildList<AbstractFeature>(this);
		
		this.feature.add(feature);
	}
	
	public void addGenericADEComponent(ADEComponent genericADEComponent) {
		if (this.genericADEComponent == null)
			this.genericADEComponent = new ChildList<ADEComponent>(this);
		
		this.genericADEComponent.add(genericADEComponent);
	}

	public List<AbstractFeature> getFeature() {
		if (feature == null)
			feature = new ChildList<AbstractFeature>(this);
		
		return feature;
	}
	
	public List<ADEComponent> getGenericADEComponent() {
		if (genericADEComponent == null)
			genericADEComponent = new ChildList<ADEComponent>(this);
		
		return genericADEComponent;
	}

	public boolean isSetFeature() {
		return feature != null && !feature.isEmpty();
	}
	
	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null && !genericADEComponent.isEmpty();
	}

	public void setFeature(List<AbstractFeature> feature) {
		this.feature = new ChildList<AbstractFeature>(this, feature);
	}
	
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent) {
		this.genericADEComponent = new ChildList<ADEComponent>(this, genericADEComponent);
	}

	public void unsetFeature() {
		if (isSetFeature())
			feature.clear();
		
		feature = null;
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.clear();
		
		genericADEComponent = null;
	}

	public boolean unsetFeature(AbstractFeature feature) {
		return isSetFeature() ? this.feature.remove(feature) : false;
	}
	
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent) {
		return isSetGenericADEComponent() ? this.genericADEComponent.remove(genericADEComponent) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATUREARRAYPROPERTY;
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
		return copyTo(new FeatureArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureArrayProperty copy = (target == null) ? new FeatureArrayPropertyImpl() : (FeatureArrayProperty)target;
		
		if (isSetFeature()) {
			for (AbstractFeature part : feature) {
				AbstractFeature copyPart = (AbstractFeature)copyBuilder.copy(part);
				copy.addFeature(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericADEComponent()) {
			for (ADEComponent part : genericADEComponent) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericADEComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
