package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.ConstructionEventProperty;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ConstructionEventPropertyAdapter extends AbstractInlinePropertyAdapter<ConstructionEventProperty> {

    @Override
    public ConstructionEventProperty createObject(QName name) {
        return new ConstructionEventProperty();
    }
}
