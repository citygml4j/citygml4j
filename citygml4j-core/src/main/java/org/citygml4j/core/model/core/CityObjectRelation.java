/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.citygml4j.core.visitor.VisitableObject;
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

    public boolean isSetGenericAttributes() {
        return genericAttributes != null && !genericAttributes.isEmpty();
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
