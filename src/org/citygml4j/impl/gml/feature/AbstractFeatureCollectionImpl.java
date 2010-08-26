package org.citygml4j.impl.gml.feature;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;

public abstract class AbstractFeatureCollectionImpl extends AbstractFeatureImpl implements AbstractFeatureCollection {
	private List<FeatureMember> featureMember;
	private FeatureArrayProperty featureMembers;
	
	public void addFeatureMember(FeatureMember featureMember) {
		if (this.featureMember == null)
			this.featureMember = new ChildList<FeatureMember>(this);
		
		this.featureMember.add(featureMember);
	}

	public List<FeatureMember> getFeatureMember() {
		if (featureMember == null)
			featureMember = new ChildList<FeatureMember>(this);
		
		return featureMember;
	}

	public FeatureArrayProperty getFeatureMembers() {
		return featureMembers;
	}
	
	public boolean isSetFeatureMember() {
		return featureMember != null && !featureMember.isEmpty();
	}

	public boolean isSetFeatureMembers() {
		return featureMembers != null;
	}

	public void setFeatureMember(List<FeatureMember> featureMember) {
		this.featureMember = new ChildList<FeatureMember>(this, featureMember);
	}

	public void setFeatureMembers(FeatureArrayProperty featureMembers) {
		if (featureMembers != null)
			featureMembers.setParent(this);
		
		this.featureMembers = featureMembers;
	}

	public void unsetFeatureMember() {
		if (isSetFeatureMember())
			featureMember.clear();
		
		featureMember = null;
	}

	public boolean unsetFeatureMember(FeatureMember featureMember) {
		return isSetFeatureMember() ? this.featureMember.remove(featureMember) : false;
	}

	public void unsetFeatureMembers() {
		if (isSetFeatureMembers())
			featureMembers.unsetParent();
		
		featureMembers = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_FEATURE_COLLECTION;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractFeatureCollection copy = (AbstractFeatureCollection)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetFeatureMember()) {
			for (FeatureMember part : featureMember) {
				FeatureMember copyPart = (FeatureMember)copyBuilder.copy(part);
				copy.addFeatureMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetFeatureMembers()) {
			copy.setFeatureMembers((FeatureArrayProperty)copyBuilder.copy(featureMembers));
			if (copy.getFeatureMembers() == featureMembers)
				featureMembers.setParent(this);
		}
		
		return copy;
	}

}
