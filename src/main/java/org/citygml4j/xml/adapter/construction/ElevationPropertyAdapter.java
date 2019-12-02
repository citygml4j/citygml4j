package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.ElevationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ElevationPropertyAdapter extends AbstractInlinePropertyAdapter<ElevationProperty> {

    @Override
    public ElevationProperty createObject(QName name) throws ObjectBuildException {
        return new ElevationProperty();
    }
}
