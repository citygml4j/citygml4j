package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.dynamizer.SensorConnectionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class SensorConnectionPropertyAdapter extends AbstractInlinePropertyAdapter<SensorConnectionProperty> {

    @Override
    public SensorConnectionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new SensorConnectionProperty();
    }
}
