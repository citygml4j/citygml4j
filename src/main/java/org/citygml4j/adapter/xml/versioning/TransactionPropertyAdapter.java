package org.citygml4j.adapter.xml.versioning;

import org.citygml4j.model.versioning.TransactionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class TransactionPropertyAdapter extends AbstractInlinePropertyAdapter<TransactionProperty> {

    @Override
    public TransactionProperty createObject(QName name) throws ObjectBuildException {
        return new TransactionProperty();
    }
}
