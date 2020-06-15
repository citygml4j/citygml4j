package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.appearance.AbstractTextureParameterizationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractTextureParameterizationPropertyAdapter extends AbstractInlinePropertyAdapter<AbstractTextureParameterizationProperty> {

    @Override
    public AbstractTextureParameterizationProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractTextureParameterizationProperty();
    }
}
