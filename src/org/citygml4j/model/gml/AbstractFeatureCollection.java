package org.citygml4j.model.gml;

import java.util.List;

public interface AbstractFeatureCollection extends AbstractFeature {
	public List<FeatureProperty<? extends AbstractFeature>> getFeatureMember();
	public FeatureArrayProperty getFeatureMembers();
	public boolean isSetFeatureMember();
	public boolean isSetFeatureMembers();
	
	public void addFeatureMember(FeatureProperty<? extends AbstractFeature> featureMember);
	public void setFeatureMembers(FeatureArrayProperty featureMembers);
	public void setFeatureMember(List<FeatureProperty<? extends AbstractFeature>> featureMember);
	public void unsetFeatureMember();
	public boolean unsetFeatureMember(FeatureProperty<? extends AbstractFeature> featureMember);
	public void unsetFeatureMembers();
}
