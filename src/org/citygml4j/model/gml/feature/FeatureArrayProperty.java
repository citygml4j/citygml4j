package org.citygml4j.model.gml.feature;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.base.ArrayAssociation;

public interface FeatureArrayProperty extends ArrayAssociation<AbstractFeature> {
	public List<? extends AbstractFeature> getFeature();
	public List<ADEComponent> getGenericADEComponent();
	public boolean isSetFeature();
	public boolean isSetGenericADEComponent();
	
	public void setFeature(List<? extends AbstractFeature> feature);
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent);
	public void addFeature(AbstractFeature feature);
	public void addGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetFeature();
	public void unsetGenericADEComponent();
	public boolean unsetFeature(AbstractFeature feature);
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent);
}
