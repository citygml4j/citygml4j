package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.model.appearance.AppearanceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AppearancePropertyAdapter extends AbstractFeaturePropertyAdapter<AppearanceProperty> {

    @Override
    public AppearanceProperty createObject(QName name) {
        return new AppearanceProperty();
    }
}
