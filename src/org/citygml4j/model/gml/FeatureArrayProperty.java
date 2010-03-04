package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.citygml.ade.ADEComponent;

public interface FeatureArrayProperty extends GML, Child, Copyable {
	public List<AbstractFeature> getFeature();
	public List<ADEComponent> getGenericADEComponent();
	public boolean isSetFeature();
	public boolean isSetGenericADEComponent();
	
	public void setFeature(List<AbstractFeature> feature);
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent);
	public void addFeature(AbstractFeature feature);
	public void addGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetFeature();
	public void unsetGenericADEComponent();
	public boolean unsetFeature(AbstractFeature feature);
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent);
}
