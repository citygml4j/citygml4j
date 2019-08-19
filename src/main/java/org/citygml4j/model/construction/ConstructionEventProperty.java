package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class ConstructionEventProperty extends AbstractInlineProperty<ConstructionEvent> implements CityGMLObject {

    public ConstructionEventProperty() {
    }

    public ConstructionEventProperty(ConstructionEvent object) {
        super(object);
    }

    @Override
    public Class<ConstructionEvent> getTargetType() {
        return ConstructionEvent.class;
    }
}
