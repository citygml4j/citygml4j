package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class CityObjectRelationProperty extends AbstractProperty<CityObjectRelation> implements CityGMLObject {

    @Override
    public Class<CityObjectRelation> getTargetType() {
        return CityObjectRelation.class;
    }
}
