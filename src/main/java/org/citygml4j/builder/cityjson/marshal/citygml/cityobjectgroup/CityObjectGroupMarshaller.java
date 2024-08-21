/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.builder.cityjson.marshal.citygml.cityobjectgroup;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.CityObjectGroupType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CityObjectGroupMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final GMLIdManager gmlIdManager = DefaultGMLIdManager.getInstance();

	public CityObjectGroupMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}

	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		if (src instanceof CityObjectGroup)
			return marshalCityObjectGroup((CityObjectGroup) src, cityJSON);

		return null;
	}

	public void marshalCityObjectGroup(CityObjectGroup src, CityObjectGroupType dest, CityJSON cityJSON) {
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

		Attributes attributes = dest.getAttributes();
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

		if (src.isSetGenericApplicationPropertyOfCityObjectGroup())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfCityObjectGroup(), dest, cityJSON);

		if (src.isSetGeometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getGeometry(), cityJSON);
			if (geometry != null)
				dest.addGeometry(geometry);
		}

		if (src.isSetGroupParent() && src.getGroupParent().isSetCityObject()) {
			AbstractCityObjectType parent = citygml.marshal(src.getGroupParent().getCityObject(), cityJSON);
			cityJSON.addCityObject(parent);
		}

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember property : src.getGroupMember()) {
				if (property.isSetCityObject()) {
					AbstractCityObject cityObject = property.getCityObject();
					if (!cityObject.isSetId())
						cityObject.setId(gmlIdManager.generateUUID());

					AbstractCityObjectType member = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
					dest.addMember(member.getGmlId());
					cityJSON.addCityObject(member);
				}

				else if (property.isSetHref()) {
					String member = property.getHref().replaceAll("^.*?#+?", "");
					dest.addMember(member);
				}
			}
		}
	}

	public CityObjectGroupType marshalCityObjectGroup(CityObjectGroup src, CityJSON cityJSON) {
		CityObjectGroupType dest = new CityObjectGroupType();
		marshalCityObjectGroup(src, dest, cityJSON);

		return dest;
	}

	public void postprocessGroupMembers(CityModel src, CityJSON cityJSON) {
		Set<String> gmlIds = cityJSON.getCityObjects().stream().map(AbstractCityObjectType::getGmlId).collect(Collectors.toSet());
		List<CityObjectGroupType> groups = cityJSON.getCityObjects().stream()
				.filter(CityObjectGroupType.class::isInstance)
				.map(CityObjectGroupType.class::cast)
				.collect(Collectors.toList());

		ChildInfo childInfo = new ChildInfo();

		for (CityObjectGroupType group : groups) {
			Set<String> candidates = new HashSet<>();

			for (Iterator<String> iter = group.getMembers().iterator(); iter.hasNext(); ) {
				String gmlId = iter.next();
				if (gmlIds.contains(gmlId))
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
							if (cityObject != member && cityObject.isSetId() && gmlIds.contains(cityObject.getId())) {
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
				candidates.forEach(group::addMember);
		}
	}

}
