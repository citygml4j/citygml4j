package org.citygml4j.model.gml;

public interface FeatureProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractFeature getFeature();
	public boolean isSetFeature();
	
	public void setFeature(AbstractFeature abstractFeature);
	public void unsetFeature();
}
