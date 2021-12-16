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

package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.VisitableObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityObjectRelation extends AbstractGML implements CityGMLObject, VisitableObject {
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private Code relationType;
    private AbstractCityObjectReference relatedTo;

    public CityObjectRelation() {
    }

    public CityObjectRelation(AbstractCityObject cityObject) {
        setRelatedTo(new AbstractCityObjectReference(cityObject));
    }

    public CityObjectRelation(String href) {
        setRelatedTo(new AbstractCityObjectReference(href));
    }

    public List<AbstractGenericAttributeProperty> getGenericAttributes() {
        if (genericAttributes == null)
            genericAttributes = new ChildList<>(this);

        return genericAttributes;
    }

    public void setGenericAttributes(List<AbstractGenericAttributeProperty> genericAttributes) {
        this.genericAttributes = asChild(genericAttributes);
    }

    public Code getRelationType() {
        return relationType;
    }

    public void setRelationType(Code relationType) {
        this.relationType = asChild(relationType);
    }

    public AbstractCityObjectReference getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(AbstractCityObjectReference relatedTo) {
        this.relatedTo = asChild(relatedTo);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
