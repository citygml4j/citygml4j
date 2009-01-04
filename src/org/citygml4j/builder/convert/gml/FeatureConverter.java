package org.citygml4j.builder.convert.gml;

import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.FeatureProperty;

public class FeatureConverter {
	private GMLConvertBuilder builder;
	
	protected FeatureConverter(GMLConvertBuilder builder) {
		this.builder = builder;
	}
	
	protected void convertAbstractFeature(AbstractFeature src, AbstractFeature dest) {
		builder.gmlBase.convertAbstractGML(src, dest);
		
		if (src.isSetBoundedBy())
			dest.setBoundedBy(src.getBoundedBy());
		
		if (src.isSetLocation())
			dest.setLocation(src.getLocation());
	}
	
	protected void convertAbstractFeatureCollection(AbstractFeatureCollection src, AbstractFeatureCollection dest) {
		convertAbstractFeature(src, dest);
		
		if (src.isSetFeatureMember())
			dest.setFeatureMember(src.getFeatureMember());
		
		if (src.isSetFeatureMembers())
			dest.setFeatureMembers(src.getFeatureMembers());
	}
	
	protected void convertFeatureProperty(FeatureProperty src, FeatureProperty dest) {
		builder.gmlBase.convertAssociationAttributeGroup(src, dest);
		
		if (src.isSetFeature())
			dest.setFeature(src.getFeature());
	}
}
