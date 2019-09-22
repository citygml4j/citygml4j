package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.model.appearance.AbstractTextureParameterizationProperty;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractTextureParameterizationPropertyAdapter extends AbstractInlinePropertyAdapter<AbstractTextureParameterizationProperty> {

    @Override
    public AbstractTextureParameterizationProperty createObject(QName name) {
        return new AbstractTextureParameterizationProperty();
    }
}
