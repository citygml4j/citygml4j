package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractAppearancePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractAppearanceProperty> {

    @Override
    public AbstractAppearanceProperty createObject(QName name) {
        return new AbstractAppearanceProperty();
    }
}
