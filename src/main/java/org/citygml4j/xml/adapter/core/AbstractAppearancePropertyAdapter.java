package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractAppearancePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractAppearanceProperty> {

    @Override
    public AbstractAppearanceProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractAppearanceProperty();
    }
}
