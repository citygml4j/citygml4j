package org.citygml4j.model.gml;

import java.util.List;

public interface AbstractFeatureCollection extends AbstractFeature {
	public List<FeatureProperty> getFeatureMember();
	public FeatureArrayProperty getFeatureMembers();
	public boolean isSetFeatureMember();
	public boolean isSetFeatureMembers();
	
	public void addFeatureMember(FeatureProperty featureMember);
	public void setFeatureMembers(FeatureArrayProperty featureMembers);
	public void setFeatureMember(List<FeatureProperty> featureMember);
	public void unsetFeatureMember();
	public boolean unsetFeatureMember(FeatureProperty featureMember);
	public void unsetFeatureMembers();
}
