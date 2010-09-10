package org.citygml4j.model.gml.feature;

import java.util.List;

public interface AbstractFeatureCollection extends AbstractFeature {
	public List<FeatureMember> getFeatureMember();
	public FeatureArrayProperty getFeatureMembers();
	public boolean isSetFeatureMember();
	public boolean isSetFeatureMembers();
	
	public void addFeatureMember(FeatureMember featureMember);
	public void setFeatureMembers(FeatureArrayProperty featureMembers);
	public void setFeatureMember(List<FeatureMember> featureMember);
	public void unsetFeatureMember();
	public boolean unsetFeatureMember(FeatureMember featureMember);
	public void unsetFeatureMembers();
}
