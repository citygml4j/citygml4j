package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class StoreyProperty extends FeatureProperty<Storey> implements CityGMLObject {

    public StoreyProperty() {
    }

    public StoreyProperty(Storey object) {
        super(object);
    }

    public StoreyProperty(String href) {
        super(href);
    }

    @Override
    public Class<Storey> getTargetType() {
        return Storey.class;
    }
}
