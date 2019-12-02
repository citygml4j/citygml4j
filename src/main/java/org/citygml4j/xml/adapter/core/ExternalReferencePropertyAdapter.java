package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.ExternalReferenceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ExternalReferencePropertyAdapter extends AbstractInlinePropertyAdapter<ExternalReferenceProperty> {

    @Override
    public ExternalReferenceProperty createObject(QName name) throws ObjectBuildException {
        return new ExternalReferenceProperty();
    }
}
