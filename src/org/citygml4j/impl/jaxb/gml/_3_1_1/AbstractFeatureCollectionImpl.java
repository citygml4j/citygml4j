package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureCollectionType;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractFeatureCollectionImpl extends AbstractFeatureImpl	implements AbstractFeatureCollection {
	private AbstractFeatureCollectionType abstractFeatureCollectionType;

	public AbstractFeatureCollectionImpl(AbstractFeatureCollectionType abstractFeatureCollectionType) {
		super(abstractFeatureCollectionType);
		this.abstractFeatureCollectionType = abstractFeatureCollectionType;
	}

	@Override
	public AbstractFeatureCollectionType getJAXBObject() {
		return abstractFeatureCollectionType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTFEATURECOLLECTION;
	}

	@Override
	public boolean isSetFeatureMember() {
		return abstractFeatureCollectionType.isSetFeatureMember();
	}

	@Override
	public boolean isSetFeatureMembers() {
		return abstractFeatureCollectionType.isSetFeatureMembers();
	}

	@Override
	public void unsetFeatureMember() {
		abstractFeatureCollectionType.unsetFeatureMember();
	}

	@Override
	public void unsetFeatureMembers() {
		abstractFeatureCollectionType.setFeatureMembers(null);
	}

}
