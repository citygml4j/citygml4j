/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.reader;

import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.gml.model.feature.BoundingShape;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

public class FeatureInfo {
    private final QName name;
    private final AbstractFeature feature;
    private final CityGMLChunk parent;

    FeatureInfo(QName name, AbstractFeature feature, CityGMLChunk parent) {
        this.name = name;
        this.feature = feature;
        this.parent = parent;
    }

    public QName getTypeName() {
        return name;
    }

    public Class<? extends AbstractFeature> getType() {
        return feature.getClass();
    }

    public boolean hasParentInfo() {
        try {
            return getParentInfo() != null;
        } catch (CityGMLReadException e) {
            return false;
        }
    }

    public FeatureInfo getParentInfo() throws CityGMLReadException {
        return parent != null ? parent.getFeatureInfo() : null;
    }

    public String getId() {
        return feature.getId();
    }

    public List<MetaDataProperty<?>> getMetaDataProperties() {
       return feature.getMetaDataProperties();
    }

    public boolean isSetMetaDataProperties() {
        return feature.isSetMetaDataProperties();
    }

    public StringOrRef getDescription() {
        return feature.getDescription();
    }

    public Reference getDescriptionReference() {
        return feature.getDescriptionReference();
    }

    public CodeWithAuthority getIdentifier() {
        return feature.getIdentifier();
    }

    public List<Code> getNames() {
        return feature.getNames();
    }

    public boolean isSetNames() {
        return feature.isSetNames();
    }

    public BoundingShape getBoundedBy() {
        return feature.getBoundedBy();
    }

    public EngineeringCRSProperty getEngineeringCRS() {
        return feature instanceof CityModel ? ((CityModel) feature).getEngineeringCRS() : null;
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (feature instanceof AbstractCityObject)
            return ((AbstractCityObject) feature).getAppearances();
        else if (feature instanceof CityModel)
            return ((CityModel) feature).getAppearanceMembers();
        else
            return Collections.emptyList();
    }

    public boolean isSetAppearances() {
        if (feature instanceof AbstractCityObject)
            return ((AbstractCityObject) feature).isSetAppearances();
        else if (feature instanceof CityModel)
            return ((CityModel) feature).isSetAppearanceMembers();
        else
            return false;
    }
}
