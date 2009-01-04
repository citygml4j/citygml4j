package org.citygml4j.builder.convert.gml;

import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.AssociationAttributeGroup;
import org.citygml4j.model.gml.StandardObjectProperties;

public class GMLBaseConverter {
	
	protected GMLBaseConverter() {
		
	}
	
	protected void convertAbstractGML(AbstractGML src, AbstractGML dest) {
		convertStandardObjectProperties(src, dest);
		
		if (src.isSetId())
			dest.setId(src.getId());		
	}
	
	protected <T extends AbstractGML> void convertAssociation(Association<T> src, Association<T> dest) {
		convertAssociationAttributeGroup(src, dest);
	}
	
	protected void convertStandardObjectProperties(StandardObjectProperties src, StandardObjectProperties dest) {
		if (src.isSetName())
			dest.setName(src.getName());
		
		if (src.isSetDescription())
			dest.setDescription(src.getDescription());
	}
	
	protected void convertAssociationAttributeGroup(AssociationAttributeGroup src, AssociationAttributeGroup dest) {
		if (src.isSetActuate())
			dest.setActuate(src.getActuate());
		
		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());
		
		if (src.isSetHref())
			dest.setHref(src.getHref());
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());
		
		if (src.isSetRole())
			dest.setRole(src.getRole());
		
		if (src.isSetShow())
			dest.setShow(src.getShow());
		
		if (src.isSetTitle())
			dest.setTitle(src.getTitle());
		
		if (src.isSetType())
			dest.setType(src.getType());
	}
	
}
