package org.citygml4j.builder.cityjson.marshal.citygml.cityobjectgroup;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.BuildingAttributes;
import org.citygml4j.binding.cityjson.feature.CityObjectGroupType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CityObjectGroupMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;

	public CityObjectGroupMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		if (src instanceof CityObjectGroup)
			return marshalCityObjectGroup((CityObjectGroup)src);

		return Collections.emptyList();			
	}

	public List<AbstractCityObjectType> marshalCityObjectGroup(CityObjectGroup src, CityObjectGroupType dest) {
		BuildingAttributes attributes = new BuildingAttributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);

		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}

		if (src.isSetGeometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getGeometry());
			if (geometry != null)
				dest.addGeometry(geometry);
		}

		List<AbstractCityObjectType> cityObjects = new ArrayList<>();

		if (src.isSetGroupParent() && src.getGroupParent().isSetCityObject()) {
			List<AbstractCityObjectType> parents = citygml.marshal(src.getGroupParent().getCityObject());
			cityObjects.addAll(parents);
		}

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember property : src.getGroupMember()) {
				if (property.isSetCityObject()) {
					AbstractCityObject cityObject = property.getCityObject();
					if (!cityObject.isSetId())
						cityObject.setId("UUID_" + UUID.randomUUID().toString());

					String gmlId = cityObject.getId();
					List<AbstractCityObjectType> members = citygml.marshal(property.getCityObject());
					cityObjects.addAll(members);

					boolean found = false;
					for (AbstractCityObjectType member : members) {
						if (gmlId.equals(member.getGmlId())) {
							dest.addMember(gmlId);
							found = true;
							break;
						}
					}

					if (!found)
						members.forEach(member -> dest.addMember(member.getGmlId()));
				}

				else if (property.isSetHref()) {
					String member = property.getHref().replaceAll("^#+", "");
					dest.addMember(member);

					dest.setLocalProperty(CityJSONMarshaller.POSTPROCESS_GROUP_MEMBERS, true);
				}
			}
		}

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalCityObjectGroup(CityObjectGroup src) {
		CityObjectGroupType dest = new CityObjectGroupType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalCityObjectGroup(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public void postprocessGroupMembers(CityObjectGroupType cityObjectGroup, CityModel src, CityJSON dest) {
		Set<String> candidates = new HashSet<>();
		ChildInfo childInfo = new ChildInfo();

		for (Iterator<String> iter = cityObjectGroup.getMembers().iterator(); iter.hasNext(); ) {
			String gmlId = iter.next();
			if (dest.hasCityObject(gmlId))
				continue;

			iter.remove();

			AbstractCityObject member = src.accept(new FeatureFunctionWalker<AbstractCityObject>() {
				public AbstractCityObject apply(AbstractCityObject cityObject) {
					return gmlId.equals(cityObject.getId()) ? cityObject : super.apply(cityObject);
				}
			});

			if (member != null) {
				member.accept(new FeatureWalker() {
					public void visit(AbstractCityObject cityObject) {
						if (cityObject != member && cityObject.isSetId() && dest.hasCityObject(cityObject.getId())) {
							boolean addCandidate = true;

							AbstractFeature parent = cityObject;
							while ((parent = childInfo.getParentFeature(parent)) != null) {
								if (parent.isSetId() && candidates.contains(parent.getId())) {
									addCandidate = false;
									break;
								}
							}

							if (addCandidate)
								candidates.add(cityObject.getId());
						}

						super.visit(cityObject);
					}
				});
			}
		}

		if (!candidates.isEmpty())
			candidates.forEach(cityObjectGroup::addMember);
	}

}
