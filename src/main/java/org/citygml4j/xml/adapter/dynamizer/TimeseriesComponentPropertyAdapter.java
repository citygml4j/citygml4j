package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.dynamizer.TimeseriesComponentProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class TimeseriesComponentPropertyAdapter extends AbstractInlinePropertyAdapter<TimeseriesComponentProperty> {

    @Override
    public TimeseriesComponentProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TimeseriesComponentProperty();
    }
}
