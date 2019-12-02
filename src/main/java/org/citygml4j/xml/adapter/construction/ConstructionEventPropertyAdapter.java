package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.ConstructionEventProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ConstructionEventPropertyAdapter extends AbstractInlinePropertyAdapter<ConstructionEventProperty> {

    @Override
    public ConstructionEventProperty createObject(QName name) throws ObjectBuildException {
        return new ConstructionEventProperty();
    }
}
