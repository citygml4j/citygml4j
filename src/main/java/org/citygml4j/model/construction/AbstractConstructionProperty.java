package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructionProperty extends FeatureProperty<AbstractConstruction> implements CityGMLObject {

    public AbstractConstructionProperty() {
    }

    public AbstractConstructionProperty(AbstractConstruction object) {
        super(object);
    }

    public AbstractConstructionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstruction> getTargetType() {
        return AbstractConstruction.class;
    }
}
