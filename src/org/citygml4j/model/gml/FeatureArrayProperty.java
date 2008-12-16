package org.citygml4j.model.gml;

import java.util.List;

public interface FeatureArrayProperty extends GMLBase {
	public List<AbstractFeature> getFeature();
	public boolean isSetFeature();
	
	public void setFeature(List<AbstractFeature> abstractFeature);
	public void addFeature(AbstractFeature abstractFeature);
	public void unsetFeature();
	public boolean unsetFeature(AbstractFeature abstractFeature);
}
