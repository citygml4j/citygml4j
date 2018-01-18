package org.citygml4j.builder.cityjson.marshal.citygml.cityobjectgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.common.base.ModelObject;

public class CityObjectGroupMarshaller {
	private final CityGMLMarshaller citygml;

	public CityObjectGroupMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		if (src instanceof CityObjectGroup)
			return marshalCityObjectGroup((CityObjectGroup)src);

		return Collections.emptyList();			
	}

	public void marshalCityObjectGroup(CityObjectGroup src, List<AbstractCityObjectType> dest) {

	}

	public List<AbstractCityObjectType> marshalCityObjectGroup(CityObjectGroup src) {
		List<AbstractCityObjectType> dest = new ArrayList<>();
		
		if (src.isSetGroupParent() && src.getGroupParent().isSetCityObject()) {
			List<AbstractCityObjectType> parents = citygml.marshal(src.getGroupParent().getCityObject());
			if (src.isSetId()) {
				for (AbstractCityObjectType parent : parents) {
					Attributes attributes = parent.isSetAttributes() ? parent.getAttributes() : parent.newAttributes();
					attributes.addGenericAttribute("parentOfGroup", src.getId());
				}
			}
			
			dest.addAll(parents);
		}
		
		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember property : src.getGroupMember()) {
				if (property.isSetCityObject()) {
					List<AbstractCityObjectType> members = citygml.marshal(property.getCityObject());
					if (src.isSetId()) {
						for (AbstractCityObjectType member : members) {
							Attributes attributes = member.isSetAttributes() ? member.getAttributes() : member.newAttributes();
							attributes.addGenericAttribute("group", src.getId());
						}
					}
					
					dest.addAll(members);
				}
			}
		}

		return dest;
	}

}
