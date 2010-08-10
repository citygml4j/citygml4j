package org.citygml4j.model.gml.feature;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface FeatureProperty<T extends AbstractFeature> extends AssociationByRepOrRef<T> {
	public T getFeature();
	public ADEComponent getGenericADEComponent();
	public boolean isSetFeature();
	public boolean isSetGenericADEComponent();
	
	public void setFeature(T feature);
	public void setGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetFeature();
	public void unsetGenericADEComponent();
}
