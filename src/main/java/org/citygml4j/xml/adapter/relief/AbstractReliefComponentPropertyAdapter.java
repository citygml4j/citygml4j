package org.citygml4j.xml.adapter.relief;

import org.citygml4j.model.relief.AbstractReliefComponentProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractReliefComponentPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractReliefComponentProperty> {

    @Override
    public AbstractReliefComponentProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractReliefComponentProperty();
    }
}
