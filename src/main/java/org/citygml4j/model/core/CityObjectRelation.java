package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.Visitable;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityObjectRelation extends AbstractGML implements CityGMLObject, Visitable {
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private Code relationType;
    private AbstractCityObjectProperty relatedTo;

    public CityObjectRelation() {
    }

    public CityObjectRelation(AbstractCityObject cityObject) {
        setRelatedTo(new AbstractCityObjectProperty(cityObject));
    }

    public CityObjectRelation(String href) {
        setRelatedTo(new AbstractCityObjectProperty(href));
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

    public AbstractCityObjectProperty getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(AbstractCityObjectProperty relatedTo) {
        this.relatedTo = asChild(relatedTo);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
