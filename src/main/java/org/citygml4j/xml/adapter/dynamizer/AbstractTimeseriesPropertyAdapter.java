package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.dynamizer.AbstractTimeseriesProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractTimeseriesPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractTimeseriesProperty> {

    @Override
    public AbstractTimeseriesProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractTimeseriesProperty();
    }
}
