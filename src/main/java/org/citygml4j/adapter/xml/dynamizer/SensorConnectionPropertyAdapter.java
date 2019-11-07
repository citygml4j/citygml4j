package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.model.dynamizer.SensorConnectionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class SensorConnectionPropertyAdapter extends AbstractInlinePropertyAdapter<SensorConnectionProperty> {

    @Override
    public SensorConnectionProperty createObject(QName name) throws ObjectBuildException {
        return new SensorConnectionProperty();
    }
}
