package org.citygml4j.impl.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureMember;

public class FeatureMemberImpl extends FeaturePropertyImpl<AbstractFeature> implements FeatureMember {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_MEMBER;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureMember copy = (target == null) ? new FeatureMemberImpl() : (FeatureMember)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureMemberImpl(), copyBuilder);
	}

}
