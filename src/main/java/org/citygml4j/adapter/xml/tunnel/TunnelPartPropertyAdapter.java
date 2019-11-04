package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.model.tunnel.TunnelPartProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class TunnelPartPropertyAdapter extends AbstractFeaturePropertyAdapter<TunnelPartProperty> {

    @Override
    public TunnelPartProperty createObject(QName name) throws ObjectBuildException {
        return new TunnelPartProperty();
    }
}
