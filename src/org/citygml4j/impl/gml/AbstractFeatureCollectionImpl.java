package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractFeatureCollectionImpl extends AbstractFeatureImpl implements AbstractFeatureCollection {
	private List<FeatureProperty<? extends AbstractFeature>> featureMember;
	private FeatureArrayProperty featureMembers;
	
	public void addFeatureMember(FeatureProperty<? extends AbstractFeature> featureMember) {
		if (this.featureMember == null)
			this.featureMember = new ChildList<FeatureProperty<? extends AbstractFeature>>(this);
		
		this.featureMember.add(featureMember);
	}

	public List<FeatureProperty<? extends AbstractFeature>> getFeatureMember() {
		if (featureMember == null)
			featureMember = new ChildList<FeatureProperty<? extends AbstractFeature>>(this);
		
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

	public void setFeatureMember(List<FeatureProperty<? extends AbstractFeature>> featureMember) {
		this.featureMember = new ChildList<FeatureProperty<? extends AbstractFeature>>(this, featureMember);
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

	public boolean unsetFeatureMember(FeatureProperty<? extends AbstractFeature> featureMember) {
		return isSetFeatureMember() ? this.featureMember.remove(featureMember) : false;
	}

	public void unsetFeatureMembers() {
		if (isSetFeatureMembers())
			featureMembers.unsetParent();
		
		featureMembers = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTFEATURECOLLECTION;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractFeatureCollection copy = (AbstractFeatureCollection)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetFeatureMember()) {
			for (FeatureProperty<? extends AbstractFeature> part : featureMember) {
				FeatureProperty<? extends AbstractFeature> copyPart = (FeatureProperty<? extends AbstractFeature>)copyBuilder.copy(part);
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
