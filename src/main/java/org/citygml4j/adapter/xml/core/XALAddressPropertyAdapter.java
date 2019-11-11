package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.XALAddressProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class XALAddressPropertyAdapter extends AbstractInlinePropertyAdapter<XALAddressProperty> {

    @Override
    public XALAddressProperty createObject(QName name) throws ObjectBuildException {
        return new XALAddressProperty();
    }
}
