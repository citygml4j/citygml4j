package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.citygml.ade.ADEComponent;

public interface FeatureProperty<T extends AbstractFeature> extends GML, AssociationAttributeGroup, Child, Copyable {
	public T getFeature();
	public ADEComponent getGenericADEComponent();
	public boolean isSetFeature();
	public boolean isSetGenericADEComponent();
	
	public void setFeature(T feature);
	public void setGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetFeature();
	public void unsetGenericADEComponent();
}
