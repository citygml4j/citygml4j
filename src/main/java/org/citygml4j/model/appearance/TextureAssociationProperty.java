package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class TextureAssociationProperty extends AbstractProperty<TextureAssociation> implements CityGMLObject {

    public TextureAssociationProperty() {
    }

    public TextureAssociationProperty(TextureAssociation object) {
        super(object);
    }

    public TextureAssociationProperty(String href) {
        super(href);
    }

    @Override
    public Class<TextureAssociation> getTargetType() {
        return TextureAssociation.class;
    }
}
