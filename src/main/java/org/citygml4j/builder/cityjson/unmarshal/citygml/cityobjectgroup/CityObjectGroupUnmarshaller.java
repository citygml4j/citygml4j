/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.builder.cityjson.unmarshal.citygml.cityobjectgroup;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.CityObjectGroupType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.util.walker.FeatureWalker;

import java.util.Iterator;

public class CityObjectGroupUnmarshaller {
    private final CityJSONUnmarshaller json;
    private final CityGMLUnmarshaller citygml;

    public CityObjectGroupUnmarshaller(CityGMLUnmarshaller citygml) {
        this.citygml = citygml;
        json = citygml.getCityJSONUnmarshaller();
    }

    public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
        if (src instanceof CityObjectGroupType)
            return unmarshalCityObjectGroup((CityObjectGroupType)src);

        return null;
    }

    public void unmarshalCityObjectGroup(CityObjectGroupType src, CityObjectGroup dest) {
        citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

        if (src.isSetAttributes()) {
            Attributes attributes = src.getAttributes();
            if (attributes.isSetClazz())
                dest.setClazz(new Code(attributes.getClazz()));

            if (attributes.isSetFunction())
                dest.addFunction(new Code(attributes.getFunction()));

            if (attributes.isSetUsage())
                dest.addUsage(new Code(attributes.getUsage()));
        }

        for (AbstractGeometryType geometryType : src.getGeometry()) {
            if (geometryType instanceof AbstractGeometryObjectType) {
                AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
                AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);

                if (geometry != null) {
                    dest.setGeometry(new GeometryProperty<>(geometry));
                    break;
                }
            }
        }

        if (src.isSetMembers()) {
            for (String member : src.getMembers())
                dest.addGroupMember(new CityObjectGroupMember("#" + member));
        }
    }

    public CityObjectGroup unmarshalCityObjectGroup(CityObjectGroupType src) {
        CityObjectGroup dest = new CityObjectGroup();
        unmarshalCityObjectGroup(src, dest);

        return dest;
    }

    public void postprocessGroupMembers(CityObjectGroup cityObjectGroup, CityModel dest) {
        if (cityObjectGroup.isSetGroupMember()) {
            dest.accept(new FeatureWalker() {
                public void visit(AbstractCityObject cityObject) {
                    if (cityObject.isSetId()) {
                        for (CityObjectGroupMember member : cityObjectGroup.getGroupMember()) {
                            if (member.isSetHref() && member.getHref().equals("#" + cityObject.getId()))
                                member.setLocalProperty("isPresent", true);
                        }
                    }

                    super.visit(cityObject);
                }
            });

            for (Iterator<CityObjectGroupMember> iter = cityObjectGroup.getGroupMember().iterator(); iter.hasNext(); ) {
                CityObjectGroupMember member = iter.next();
                if (!member.hasLocalProperty("isPresent"))
                    iter.remove();

                member.unsetLocalProperty("isPresent");
            }
        }
    }

}
