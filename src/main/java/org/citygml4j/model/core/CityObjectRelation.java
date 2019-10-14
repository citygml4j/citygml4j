package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;

public class CityObjectRelation extends AbstractGML implements CityGMLObject {
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
}
