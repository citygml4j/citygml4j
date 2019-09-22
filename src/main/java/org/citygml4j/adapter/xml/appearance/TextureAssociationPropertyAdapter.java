package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.model.appearance.TextureAssociationProperty;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class TextureAssociationPropertyAdapter extends AbstractPropertyAdapter<TextureAssociationProperty> {

    @Override
    public TextureAssociationProperty createObject(QName name) {
        return new TextureAssociationProperty();
    }
}
