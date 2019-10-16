package org.citygml4j.adapter.xml.landuse;

import org.citygml4j.model.landuse.LandUseProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class LandUsePropertyAdapter extends AbstractFeaturePropertyAdapter<LandUseProperty> {

    @Override
    public LandUseProperty createObject(QName name) {
        return new LandUseProperty();
    }
}
