package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class AbstractTextureParameterizationProperty extends AbstractInlineProperty<AbstractTextureParameterization> implements CityGMLObject {

    public AbstractTextureParameterizationProperty() {
    }

    public AbstractTextureParameterizationProperty(AbstractTextureParameterization object) {
        super(object);
    }

    @Override
    public Class<AbstractTextureParameterization> getTargetType() {
        return AbstractTextureParameterization.class;
    }
}
