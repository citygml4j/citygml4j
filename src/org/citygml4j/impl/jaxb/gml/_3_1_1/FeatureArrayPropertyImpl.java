package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.FeatureArrayPropertyType;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public abstract class FeatureArrayPropertyImpl extends GMLBaseImpl implements FeatureArrayProperty {
	private FeatureArrayPropertyType featureArrayPropertyType;

	public FeatureArrayPropertyImpl(FeatureArrayPropertyType featureArrayPropertyType) {
		this.featureArrayPropertyType = featureArrayPropertyType;
	}

	@Override
	public FeatureArrayPropertyType getJAXBObject() {
		return featureArrayPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.FEATUREARRAYPROPERTY;
	}

}
